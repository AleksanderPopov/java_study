package golovatch.courses.multithreading.labs.optimized_buffer_b;

/**
 * Created by Alex on 11/13/2016.
 */
public class Producer implements Runnable {
    private SingleElementBufferOptimized_A buffer;
    private int item;
    private int periodMills;

    public Producer(SingleElementBufferOptimized_A buffer, int from, int periodMills) {
        this.buffer = buffer;
        this.item = from;
        this.periodMills = periodMills;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Produced item '" + item + "'");
            try {
                buffer.put(item++);
                Thread.sleep(periodMills);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
