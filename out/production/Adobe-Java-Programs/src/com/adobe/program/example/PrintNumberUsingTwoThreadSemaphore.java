package com.adobe.program.example;

import java.util.concurrent.Semaphore;

class OddPrint implements Runnable {
    Semaphore one;
    Semaphore two;

    public OddPrint(Semaphore one, Semaphore two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i = i + 2) {
            try {
                one.acquire();
                System.out.println(Thread.currentThread().getName() + " : " + i);
                two.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenPrint implements Runnable {
    Semaphore one;
    Semaphore two;

    public EvenPrint(Semaphore one, Semaphore two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 100; i = i + 2) {
            try {
                two.acquire();
                System.out.println(Thread.currentThread().getName() + " : " + i);
                one.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class PrintNumberUsingTwoThreadSemaphore {
    public static void main(String[] args) {
        Semaphore one = new Semaphore(1);
        Semaphore two = new Semaphore(0);
        Thread t1 = new Thread(new OddPrint(one, two));
        Thread t2 = new Thread(new EvenPrint(one, two));
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
