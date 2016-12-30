package golovatch.courses.multithreading;

/**
 * Created by Alex on 11/10/2016.
 */
public class StartRunDemo {
    public static void main(String[] args) {
        Thread t0 = new MyThread();
        t0.start();

        new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.run();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Overridden run()");
        }
    }
}
