package golovatch.courses.multithreading.labs.rabbit_attack;

import golovatch.courses.multithreading.labs.play_the_accordion.PrintRunnable;

/**
 * Created by Alex on 11/10/2016.
 */
public class RabbitPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread children = new Thread(new PrintRunnable(spaces(i) + String.valueOf(i), 100));
            children.start();
//            try {
//                children.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }

}
