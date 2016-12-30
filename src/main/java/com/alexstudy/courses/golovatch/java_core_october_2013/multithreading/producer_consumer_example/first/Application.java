package golovatch.courses.multithreading.producer_consumer_example.first;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 11/13/2016.
 */
public class Application {
    public static volatile boolean finish = false;
    private static List<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        ProducerRunnable producerR = new ProducerRunnable(queue);
        ConsumerRunnable consumerR1 = new ConsumerRunnable(queue, 0, 50);
        ConsumerRunnable consumerR2 = new ConsumerRunnable(queue, 51, 100);

        Thread producer = new Thread(producerR);
        Thread consumer1 = new Thread(consumerR1);
        Thread consumer2 = new Thread(consumerR2);

        producer.start();
        Thread.sleep(1000);
        consumer1.start();
        consumer2.start();

        producer.join();
        consumer1.join();
        consumer2.join();

        System.out.println("Consumer1 content:");
        System.out.println(consumerR1.getContent());
        System.out.println("Consumer2 content:");
        System.out.println(consumerR2.getContent());
    }
}
