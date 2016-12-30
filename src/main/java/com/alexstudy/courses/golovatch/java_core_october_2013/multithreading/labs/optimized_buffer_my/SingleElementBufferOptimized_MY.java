package golovatch.courses.multithreading.labs.optimized_buffer_my;


/**
 * Created by Alex on 11/13/2016.
 */
public class SingleElementBufferOptimized_MY {
    private Integer elem = null;
    private final Object consumers = new Object();
    private final Object producers = new Object();
    private int producersCount = 0;
    private int consumersCount = 0;

    public static void main(String[] args) throws InterruptedException {
        SingleElementBufferOptimized_MY buffer = new SingleElementBufferOptimized_MY();
        new Thread(new Producer(buffer, 1, 500)).start();
        Thread.sleep(1000);
        new Thread(new Consumer(buffer)).start();
    }

    public synchronized void put(Integer newElem) throws InterruptedException {
        while (elem != null) {
            synchronized (consumers) { consumers.notify(); }
            synchronized (producers) { producers.wait(); }
            new Thread();
            System.out.println("put realised");
        }
        this.elem = newElem;
        synchronized (consumers) { consumers.notify(); }
        synchronized (producers) { producers.wait();
            System.out.println("put realised");
        }
    }

    public synchronized Integer get() throws InterruptedException {
        while (elem == null) {
            synchronized (producers) { producers.notify(); }
            synchronized (consumers) { consumers.wait(); }
        }
        int result = this.elem;
        this.elem = null;
        synchronized (producers) { producers.notify(); }
        synchronized (consumers) { consumers.wait(); }
        return result;
    }
}
