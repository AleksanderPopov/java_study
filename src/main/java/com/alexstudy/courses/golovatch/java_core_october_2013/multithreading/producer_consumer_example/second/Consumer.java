package golovatch.courses.multithreading.producer_consumer_example.second;

/**
 * Created by Alex on 11/13/2016.
 */
public class Consumer implements Runnable {
    private SingleItemBuffer buffer;

    public Consumer(SingleItemBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Item '" + buffer.get() + "' consumed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
