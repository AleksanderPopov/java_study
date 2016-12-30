package golovatch.courses.multithreading;

/**
 * Created by Alex on 11/9/2016.
 */
public class CounterDemo {
    private static final int N = 100_000_000;
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counterPlusPlus();
                }
            }
        });
        t0.start();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counterPlusPlus();
                }
            }
        });
        t1.start();

        t0.join();
        t1.join();
        System.out.println(counter);
    }

    private static synchronized void counterPlusPlus() {
        counter++;
    }
}
