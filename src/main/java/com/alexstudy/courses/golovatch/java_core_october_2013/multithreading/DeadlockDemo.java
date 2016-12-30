package golovatch.courses.multithreading;

/**
 * Created by Alex on 11/9/2016.
 */
public class DeadlockDemo {
    private static Thread t1;
    private static Thread t2;

    public static void main(String[] args) {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
