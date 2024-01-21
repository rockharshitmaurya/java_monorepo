package com.worker.multiple;
import java.util.concurrent.*;

public class TestMultipleExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(3);

        Runnable aTask1=new Runnable(){ //Using Anonymous class
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Task1...Started");
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                System.out.println("Task1...Ended");
            }
        };

        Runnable aTask2=()->{ //using lamba
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task2...Started");
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
            System.out.println("Task2...Ended");
        };

        Runnable aTask3=()->{ //using lamba
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task3...Started");
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
            System.out.println("Task3...Ended");
        };

        Runnable aTask4=()->{ //using lamba
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task4...Started");
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
            System.out.println("Task4...Ended");
        };



        executorService.submit(aTask1);
        executorService.submit(aTask2);
        executorService.submit(aTask3);
        executorService.submit(aTask4);

        executorService.shutdown();

    }
}
