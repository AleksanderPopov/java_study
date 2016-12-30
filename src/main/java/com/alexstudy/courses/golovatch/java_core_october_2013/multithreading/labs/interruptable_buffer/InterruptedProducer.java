package golovatch.courses.multithreading.labs.interruptable_buffer;

/**
 * Created by apop on 11/23/2016.
 */
public class InterruptedProducer implements Runnable {
    private int startValue;
    private final Interrupt_Buffer buffer;

    public InterruptedProducer(int startValue, Interrupt_Buffer buffer) {
        this.buffer = buffer;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue + " produced");
                buffer.put(startValue++);
                Thread.sleep((int) (1000 * Math.random()));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}