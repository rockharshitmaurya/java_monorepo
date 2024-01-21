package com.worker.single;

public class TestRunnable  implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Task3...");
    }
}
