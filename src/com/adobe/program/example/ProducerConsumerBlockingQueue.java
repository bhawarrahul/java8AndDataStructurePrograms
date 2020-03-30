package com.adobe.program.example;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {
    static int MAX_SIZE = 10;
    static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(MAX_SIZE);

    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
    }

    static class Producer extends Thread {
        Random random = new Random();

        public void run() {
            while (true) {
                int element = random.nextInt(MAX_SIZE);
                try {
                    queue.put(element);
                    System.out.println("Produced " + element);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class Consumer extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Consumed " + queue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
