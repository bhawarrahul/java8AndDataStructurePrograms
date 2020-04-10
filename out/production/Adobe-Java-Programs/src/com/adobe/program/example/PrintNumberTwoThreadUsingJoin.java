package com.adobe.program.example;

class MainThread1 {
    private int max;
    private int count = 1;

    public MainThread1() {
        this.max = 20;
    }

    public void print1To10() {
        synchronized (this) {
            while (count <= 10) {
                System.out.print(" " + (count++));
            }
        }
    }

    public void print11To20(Thread t1) {
        synchronized (this) {
            while (count <= max) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(" " + (count++));
            }
        }
    }
}


public class PrintNumberTwoThreadUsingJoin {
    public static void main(String[] args) {
        MainThread1 mainThread = new MainThread1();
        Thread t1 = new Thread(() -> {
            mainThread.print1To10();
        });
        Thread t2 = new Thread(() -> {
            mainThread.print11To20(t1);
        });
        t1.start();
        t2.start();
    }
}
