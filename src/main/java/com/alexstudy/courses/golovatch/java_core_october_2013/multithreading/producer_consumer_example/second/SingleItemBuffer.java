package golovatch.courses.multithreading.producer_consumer_example.second;

/**
 * Created by Alex on 11/13/2016.
 */
public class SingleItemBuffer {
    private Integer item = null;

    public synchronized void put(int i) throws InterruptedException {
        while (item != null) this.wait();
        item = i;
        this.notifyAll();
    }

    public synchronized Integer get() throws InterruptedException {
        while (item == null) this.wait();
        int tmp = item;
        item = null;
        this.notifyAll();
        return tmp;
    }
}
