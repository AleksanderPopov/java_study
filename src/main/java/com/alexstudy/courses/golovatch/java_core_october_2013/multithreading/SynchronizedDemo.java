package golovatch.courses.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 11/11/2016.
 */
public class SynchronizedDemo {
    private final List<String> names = new ArrayList<>(5);

    private void addName(String name) {
        synchronized (names) {
            names.add(name);
        }
    }

    private synchronized void addNameSync (String name) {
        names.add(name);
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo demo = new SynchronizedDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.addNameSync("Marina");
                demo.addNameSync("Marina");
                demo.addNameSync("Marina");
                demo.addNameSync("Marina");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.addNameSync("Alex");
                demo.addNameSync("Alex");
                demo.addNameSync("Alex");
                demo.addNameSync("Alex");
            }
        }).start();

        Thread.sleep(100);
        System.out.println(Arrays.toString(demo.names.toArray()));
    }
}
