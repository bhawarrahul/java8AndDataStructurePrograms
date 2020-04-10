package com.adobe.program.java8;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumerBlockingQueueJava8 {
    private static int MAX_SIZE = 10;
    private final static BlockingQueue<Integer> B_QUEUE = new LinkedBlockingQueue<>(MAX_SIZE);

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            while (true) {
                IntStream.range(1, 4).forEach(el -> {
                    int element = new Random().nextInt(MAX_SIZE);
                    try {
                        B_QUEUE.put(element);
                        System.out.println("Produced :- " + element);
                    } catch (InterruptedException e) {
                    }
                });
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Consumed :- " + B_QUEUE.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
