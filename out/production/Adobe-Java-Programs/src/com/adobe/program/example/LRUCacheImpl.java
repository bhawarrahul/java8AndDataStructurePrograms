package com.adobe.program.example;

import java.util.*;

class LRUExample {
    private Deque<Integer> dq;
    private HashSet<Integer> set;
    private int cSize;

    public LRUExample(final int cacheSize) {
        this.cSize = cacheSize;
        dq = new LinkedList<>();
        set = new HashSet<>();
    }

    public void cacheObject(final int data) {
        if (!set.contains(data)) {
            if (dq.size() == cSize) {
                final int tempData = dq.removeLast();
                set.remove(tempData);
            }
        } else {
            Iterator<Integer> it = dq.iterator();
            int index = 0;
            while (it.hasNext()) {
                if (it.next() == data) {
                    break;
                }
                index++;
            }
            dq.remove(index);
            set.remove(data);
        }
        dq.push(data);
        set.add(data);
    }

    public void print() {
        Iterator<Integer> it = dq.iterator();
        int index = 0;
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}


public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUExample lruExample = new LRUExample(4);
        Arrays.asList(1, 2, 3, 1, 4, 5, 1).stream().forEach(element -> lruExample.cacheObject(element));
        lruExample.print();
    }

}
