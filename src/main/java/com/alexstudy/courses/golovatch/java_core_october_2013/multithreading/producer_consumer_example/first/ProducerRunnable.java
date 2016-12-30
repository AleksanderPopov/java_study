package golovatch.courses.multithreading.producer_consumer_example.first;

import java.util.List;

/**
 * Created by Alex on 11/13/2016.
 */
public class ProducerRunnable implements Runnable {
    private final List<Integer> queue;

    public ProducerRunnable(List<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Producer started.");

        for (int i = 0; i < 5; i++) {
            synchronized (queue) {
                try {
                    queue.add((int) (Math.random() * 100));
                    System.out.println("Producer added new number.");
                    System.out.println(queue);
                    queue.notifyAll();
                    queue.wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (queue) {
            queue.notifyAll();
            Application.finish = true;
            System.out.println("Producer finished.");
        }
    }
}
