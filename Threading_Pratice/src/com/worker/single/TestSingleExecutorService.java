package com.worker.single;
import java.util.concurrent.*;
public class TestSingleExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newSingleThreadExecutor();

        Runnable aTask1=new Runnable(){ //Using Anonymous class
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Task1...");
            }
        };

        Runnable aTask2=()->{ //using lamba
                System.out.println(Thread.currentThread().getName());
                System.out.println("Task2...");
        };

        TestRunnable aTask3=new TestRunnable(); //using traditional way

        executorService.submit(aTask1);
        executorService.submit(aTask2);
        executorService.submit(aTask3);

        executorService.shutdown();

    }
}
