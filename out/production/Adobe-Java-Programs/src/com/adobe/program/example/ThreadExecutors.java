package com.adobe.program.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskClass implements Runnable {

    private String taskName;

    public TaskClass(final String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task Started: " + taskName);
            for (int i = 0; i < 5; i++) {
                System.out.println(taskName + ": Task value: " + i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Task Ended: " + taskName);
    }
}

public class ThreadExecutors {
    public static void main(String[] args) {
        TaskClass t1 = new TaskClass("Task 1");
        TaskClass t2 = new TaskClass("Task 2");
        TaskClass t3 = new TaskClass("Task 3");
        TaskClass t4 = new TaskClass("Task 4");
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(t1);
        service.submit(t2);
        service.submit(t3);
        service.submit(t4);

        service.shutdown();

        service = Executors.newSingleThreadExecutor();
        service.submit(t1);
        service.submit(t2);
        service.submit(t3);
        service.submit(t4);

        service.shutdown();

    }
}
