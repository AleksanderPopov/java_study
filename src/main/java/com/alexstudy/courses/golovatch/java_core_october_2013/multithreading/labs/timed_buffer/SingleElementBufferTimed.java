package golovatch.courses.multithreading.labs.timed_buffer;

/**
 * Created by Alex on 11/13/2016.
 */
import java.util.concurrent.TimeoutException;

public class SingleElementBufferTimed {
    private Integer elem = null;

    public synchronized void put(Integer newElem, long timeout) throws InterruptedException, TimeoutException {
        long waitTime = timeout;
        while (elem != null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
            if (waitTime > 100) waitTime = timeout;
        }
        if (waitTime <= 0) throw new TimeoutException("Timeout expired - " + timeout + "ms");
        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized Integer get(long timeout) throws InterruptedException, TimeoutException {
        long waitTime = timeout;
        while (elem == null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
            if (waitTime > 100) waitTime = timeout;
        }
        if (waitTime <= 0) throw new TimeoutException("Timeout expired - " + timeout + "ms");
        // todo: insert throw new TimeoutException
        int result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
