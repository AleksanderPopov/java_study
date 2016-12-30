package golovatch.courses.multithreading.labs.optimized_buffer_b;


/**
 * Created by Alex on 11/13/2016.
 */
public class SingleElementBufferOptimized_A {
    private int waitedProducers = 0;
    private int waitedConsumers = 0;
    private Integer elem = null;

    public static void main(String[] args) throws InterruptedException {
        SingleElementBufferOptimized_A buffer = new SingleElementBufferOptimized_A();
        new Thread(new Producer(buffer, 1, 1000)).start();
        Thread t0 = new Thread(new Consumer(buffer));
        t0.start();
        Thread.sleep(5000);
        t0.interrupt();
    }

    public synchronized void put(Integer newElem) throws InterruptedException {
        while (elem != null) {
            this.wait();
            if (elem != null) {
                this.notify();
            }
        }
        this.elem = newElem;
        this.notify();
    }

    public synchronized Integer get() throws InterruptedException {
        while (elem == null) {
            this.wait();
            if (elem == null) {
                this.notify();
            }
        }
        int result = this.elem;
        this.elem = null;
        this.notify();
        return result;
    }
}
