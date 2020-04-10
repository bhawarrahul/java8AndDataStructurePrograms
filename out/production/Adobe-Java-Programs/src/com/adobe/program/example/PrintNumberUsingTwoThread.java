package com.adobe.program.example;

class MainThread {
    private int max;
    private int threadNumber;
    private int count = 1;

    public MainThread() {
        this.max = 20;
        this.threadNumber = 0;
    }

    public void print1To10() {
        synchronized (this) {
            while (count <= 10) {
                while (threadNumber != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(" " + (count++));
            }
            notify();
            threadNumber = 1;
        }
    }

    public void print11To20() {
        synchronized (this) {
            while (count <= max) {
                while (threadNumber != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(" " + (count++));
            }
            notify();
            threadNumber = 0;
        }
    }
}

public class PrintNumberUsingTwoThread {
    public static void main(String[] args) {
        MainThread mainThread = new MainThread();
        Thread t1 = new Thread(() -> {
            mainThread.print1To10();
        });
        Thread t2 = new Thread(() -> {
            mainThread.print11To20();
        });
        t1.start();
        t2.start();
    }
}
