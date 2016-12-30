package golovatch.courses.exception.labs;

/**
 * Created by apop on 8/25/2016.
 */
public class ThreadExceptionDemo {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.err.println("Hello" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.err.println("Hello" + Thread.currentThread().getName());
        throw new RuntimeException();
    }
}
