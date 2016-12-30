package golovatch.courses.multithreading.labs.optimized_buffer_my;

/**
 * Created by Alex on 11/13/2016.
 */
public class Consumer implements Runnable {
    private SingleElementBufferOptimized_MY buffer;

    public Consumer(SingleElementBufferOptimized_MY buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("Consumer started");
        while (true) {
            try {
                System.out.println("Item '" + buffer.get() + "' consumed.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
//                e.printStackTrace();
            }
        }
    }
}
