package golovatch.courses.multithreading.labs.optimized_buffer_a;



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
            waitedProducers++;
            this.wait();
            waitedProducers--;
        }
        this.elem = newElem;
        if (waitedConsumers > 0) {
            System.out.println("put notify");
            this.notify();
        }
    }

    public synchronized Integer get() throws InterruptedException {
        while (elem == null) {
            waitedConsumers++;
            this.wait();
            waitedConsumers--;
        }
        int result = this.elem;
        this.elem = null;
        if (waitedProducers > 0) {
            System.out.println("get notify");
            this.notify();
        }
        return result;
    }
}
