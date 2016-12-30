package golovatch.courses.multithreading.labs.interruptable_buffer;

/**
 * Created by apop on 11/23/2016.
 */
public class ThreadNode {
    public Thread thread;
    public ThreadNode nextNode;

    public ThreadNode(Thread thread, ThreadNode nextNode) {
        this.thread = thread;
        this.nextNode = nextNode;
    }
}
