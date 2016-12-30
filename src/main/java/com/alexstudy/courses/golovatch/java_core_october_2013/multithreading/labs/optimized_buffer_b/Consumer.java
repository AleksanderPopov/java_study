package golovatch.courses.multithreading.labs.optimized_buffer_b;

/**
 * Created by Alex on 11/13/2016.
 */
public class Consumer implements Runnable {
    private SingleElementBufferOptimized_A buffer;

    public Consumer(SingleElementBufferOptimized_A buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
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
