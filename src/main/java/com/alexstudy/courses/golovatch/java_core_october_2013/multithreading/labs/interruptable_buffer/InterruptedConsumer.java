package golovatch.courses.multithreading.labs.interruptable_buffer;

/**
 * Created by apop on 11/23/2016.
 */
public class InterruptedConsumer implements Runnable {
    private final Interrupt_Buffer buffer;

    public InterruptedConsumer(Interrupt_Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int elem = buffer.get();
            System.out.println(elem + " consumed");
        }
    }
}