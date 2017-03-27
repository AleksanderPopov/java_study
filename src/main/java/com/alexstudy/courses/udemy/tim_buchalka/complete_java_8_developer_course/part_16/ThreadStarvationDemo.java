package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Alex on 11/1/2016.
 */
public class ThreadStarvationDemo {
    private static Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker(), "worker1");
        Thread t2 = new Thread(new Worker(), "worker2");
        Thread t3 = new Thread(new Worker(), "worker3");
        Thread t4 = new Thread(new Worker(), "worker4");
        Thread t5 = new Thread(new Worker(), "worker5");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);
        executorService.shutdown();

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
    }

    private static class Worker implements Runnable {
        int count = 0;
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ", count = " + count++);
                }
            }
        }
    }
}
