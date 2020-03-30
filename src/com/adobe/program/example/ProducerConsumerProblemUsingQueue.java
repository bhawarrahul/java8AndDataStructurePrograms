package com.adobe.program.example;

import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {

    private Queue<Integer> sharedQueue;
    private int size;

    public Producer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.size = size;
    }

    @Override
    public void run() {
        int i = 0;
        synchronized (sharedQueue) {
            while (i < size) {
                if (sharedQueue.size() == size) {
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedQueue.add(i);
                System.out.println("Produce - " + i);
                sharedQueue.notify();
                i++;
            }
        }
    }
}

class Consumer implements Runnable {

    private Queue<Integer> sharedQueue;
    private int size;

    public Consumer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.size = size;
    }

    @Override
    public void run() {
        synchronized (sharedQueue) {
            while (true) {
                if (sharedQueue.isEmpty()) {
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = sharedQueue.remove();
                System.out.println("Consume - " + i);
                sharedQueue.notify();
            }
        }
    }
}


public class ProducerConsumerProblemUsingQueue {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        Thread t1 = new Thread(new Producer(sharedQueue, 20));
        Thread t2 = new Thread(new Consumer(sharedQueue, 20));
        t1.start();
        t2.start();
    }
}
