package golovatch.courses.multithreading.producer_consumer_example.first;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 11/13/2016.
 */
public class ConsumerRunnable implements Runnable {
    private final List<Integer> queue;
    private volatile List<Integer> myList = new LinkedList<>();
    private int from;
    private int to;

    public ConsumerRunnable(List<Integer> queue, int from, int to) {
        this.queue = queue;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        System.out.println("Consumer start");
        while (!Application.finish) {
            synchronized (queue) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int item = queue.get(0);
                if (isSuite(item)) {
                    myList.add(item);
                    queue.remove(0);
                }
                System.out.println("Consumer polled the item '" + item + "' from queue, waiting");
            }
        }
        System.out.println("Consumer finish");
    }

    public List<Integer> getContent() {
        return myList;
    }

    private boolean isSuite(int item) {
        return (item >= from & item <= to);
    }
}
