package golovatch.courses.multithreading.labs.timed_buffer;

/**
 * Created by Alex on 11/13/2016.
 */
public class SingleElementBufferTimedTest {
    public static void main(String[] args) {
        int producerSleepTime = 0;
        int consumerSleepTime = 1000;

        SingleElementBufferTimed buffer = new SingleElementBufferTimed();
//        new Thread(new ProducerTimed(1, 1000, buffer, 3000)).start();
//        new Thread(new ConsumerTimed(buffer, 3000), "Consumer").start();
        new Thread(new ProducerTimed(1, 1000, buffer, producerSleepTime)).start();
        new Thread(new ConsumerTimed(buffer, consumerSleepTime), "Consumer").start();
    }
}
