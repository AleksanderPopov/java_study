package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_16;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alex on 11/1/2016.
 */
public class FairLockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(new FairLockDemo.Worker(), "worker1");
        Thread t2 = new Thread(new FairLockDemo.Worker(), "worker2");
        Thread t3 = new Thread(new FairLockDemo.Worker(), "worker3");
        Thread t4 = new Thread(new FairLockDemo.Worker(), "worker4");
        Thread t5 = new Thread(new FairLockDemo.Worker(), "worker5");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.execute(t1);
//        executorService.execute(t2);
//        executorService.execute(t3);
//        executorService.execute(t4);
//        executorService.execute(t5);
//        executorService.shutdown();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable {
        int count = 0;
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (!lock.tryLock()) {
                    i--;
                    continue;
                }
                try {
//                    System.out.println(Thread.currentThread().getName() + ", count = " + count++);
                    System.out.format("%s, count = %d\n", Thread.currentThread().getName(), count++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
