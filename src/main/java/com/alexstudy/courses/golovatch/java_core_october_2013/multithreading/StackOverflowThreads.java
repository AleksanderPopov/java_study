package golovatch.courses.multithreading;

/**
 * Created by Alex on 11/9/2016.
 */
public class StackOverflowThreads {

    // program will wait forever
    /*static {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long[] arr = new long[1000];
                    while (true) {
                        arr[0] = 0L;
                    }
                }
            }).start();
            System.out.println(Thread.activeCount());
        }
    }
}
