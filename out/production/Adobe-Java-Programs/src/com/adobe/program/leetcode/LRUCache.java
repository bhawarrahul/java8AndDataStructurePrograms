package com.adobe.program.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    class LinkedCappedHashMap<intKey, intValue> extends LinkedHashMap<intKey, intValue> {
        int cap;

        LinkedCappedHashMap(int cap) {
            super(16, 0.75f, true);
            this.cap = cap;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > cap;
        }
    }

    Map<Integer, Integer> map;

    public LRUCache(int cap) {
        map = new LinkedCappedHashMap<>(cap);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
