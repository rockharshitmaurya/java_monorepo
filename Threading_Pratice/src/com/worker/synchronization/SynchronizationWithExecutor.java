package com.worker.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizationWithExecutor {
    public static void main(String[] args) {
        int numberOfTasks = 5;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        Runnable aTask1=() -> {
            System.out.println("Executing task");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown(); // Signal that task is completed
        };

        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(aTask1);
        }

        try {

            latch.await(); // Wait for all tasks to complete
            System.out.println("All tasks have completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

