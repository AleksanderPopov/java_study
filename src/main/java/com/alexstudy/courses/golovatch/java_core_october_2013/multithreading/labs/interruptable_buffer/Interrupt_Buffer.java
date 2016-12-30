package golovatch.courses.multithreading.labs.interruptable_buffer;

/**
 * Created by apop on 11/23/2016.
 */
public class Interrupt_Buffer {
    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    public synchronized void put(int newElem) {
        while (elem != null) {
            try {
                // ?
                if (producers == null) producers = new ThreadNode(Thread.currentThread(), null);
                else {
                    ThreadNode tmp = producers;
                    while (tmp.nextNode != null) tmp = tmp.nextNode;
                    tmp.nextNode = new ThreadNode(Thread.currentThread(), null);
                }
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        elem = newElem;
        if (consumers != null) {
            consumers.thread.interrupt();
            consumers = consumers.nextNode;
        }
    }

    public synchronized int get() {
        while (elem == null) {
            try {
                // ?
                if (consumers == null) consumers = new ThreadNode(Thread.currentThread(), null);
                else {
                    ThreadNode tmp = consumers;
                    while (tmp.nextNode != null) tmp = tmp.nextNode;
                    tmp.nextNode = new ThreadNode(Thread.currentThread(), null);
                }
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        int result = elem;
        elem = null;
        if (producers != null) {
            producers.thread.interrupt();
            // ?
            producers = producers.nextNode;
        }
        return result;
    }
}
