package golovatch.courses.multithreading.producer_consumer_example.second;

/**
 * Created by Alex on 11/13/2016.
 */
public class Producer implements Runnable {
    private  SingleItemBuffer buffer;
    private int item;
    private int periodMills;

    public Producer(SingleItemBuffer buffer, int from, int periodMills) {
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
