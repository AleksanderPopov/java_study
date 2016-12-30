package golovatch.courses.multithreading;

/**
 * Created by Alex on 11/11/2016.
 */
public class WaitNotifyDemo {
    private static volatile int count = 0;
    private static String msg = "";

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        String[] words = {"Hello", "guys", "how", "are", "you?"};

        // writer
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Writer thread started");
                synchronized (lock) {
                    System.out.println("Write thread captured the lock");
                    for (String word : words) {
                        msg = word;
                        System.out.println("Waiter thread assigned new word to msg, notify reader and go wait");
                        lock.notify();
                        try {
                            System.out.println("Write thread waiting");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    lock.notify();
                    System.out.println("Writer thread exit.");
                }
            }
        }).start();

        Thread.sleep(500);

        // reader
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Reader thread started");
                while (count == 0) {
                    synchronized (lock) {
                        System.out.println("Reader thread captured the lock");

                        try {
                            System.out.println("Reader thread printing the message");
                            System.out.println(msg);
                            System.out.println("Reader thread - message printed, notify writer and wait...");
                            lock.notify();
                            lock.wait();
                            System.out.println("Reader thread woke up");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
