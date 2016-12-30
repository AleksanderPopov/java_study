package golovatch.courses.multithreading.labs.rabbit_attack;

/**
 * Created by Alex on 11/10/2016.
 */
public class Lab_Thread_Thread_Rabbit_Attack {
    public static void main(String[] args) throws InterruptedException {
//        for (int k = 1; k < 10000000; k++) {
//            String spaces = spaces(k);
//            Runnable printer = new PrintRunnable(spaces + k, 100);
//            Thread thread = new Thread(printer);
//            thread.start();
//            Thread.sleep(100);
//        }
        new Thread(new RabbitPrinter()).start();
    }

}
