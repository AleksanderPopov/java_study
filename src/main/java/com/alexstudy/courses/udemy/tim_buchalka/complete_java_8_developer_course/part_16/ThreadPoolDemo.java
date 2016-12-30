package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * Created by Alex on 10/25/2016.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Producer(list, lock));
        executor.execute(new Consumer(list, lock));
        executor.execute(new Consumer(list, lock));

        Future<String> futureResult = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Alex";
            }
        });

        executor.shutdown();
        try {
            System.out.println(futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class Producer implements Runnable {
        private List<String> messages;
        private ReentrantLock lock;

        public Producer(List<String> messages, ReentrantLock lock) {
            this.messages = messages;
            this.lock = lock;
        }

        @Override
        public void run() {
            System.err.println("Producer run() started.");
            String[] arr = {"one", "two", "three", "four", "five", "end"};
            for (String s : arr) {
                lock.lock();
                System.out.println("Adding '" + s + "' to the list");
                try {
                    messages.add(s);
                    sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
            }
            System.err.println("Producer run() finished.");
        }
    }

    static class Consumer implements Runnable {
        private List<String> messages;
        private ReentrantLock lock;

        public Consumer(List<String> messages, ReentrantLock lock) {
            this.messages = messages;
            this.lock = lock;
        }

        @Override
        public void run() {
            System.err.println("Consumer run() started.");
            int counter = 0;
            while (true) {
                if (lock.tryLock()) {
                    try {
                        if (messages.isEmpty()) continue;
                        System.out.println("Count = " + counter);
                        if (messages.get(0).equalsIgnoreCase("end")) break;
                        System.out.println("Readed and deleted '" + messages.remove(0) + "'");
                    } finally {
                        lock.unlock();
                    }
                } else counter++;
            }
            System.err.println("Consumer run() finished.");
        }
    }
}