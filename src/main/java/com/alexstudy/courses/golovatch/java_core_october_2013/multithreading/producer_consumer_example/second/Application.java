package golovatch.courses.multithreading.producer_consumer_example.second;

/**
 * Created by Alex on 11/13/2016.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        SingleItemBuffer buffer = new SingleItemBuffer();
        new Thread(new Producer(buffer, 0, 1000)).start();

        Thread.sleep(5000);
        new Thread(new Consumer(buffer)).start();
    }
}
