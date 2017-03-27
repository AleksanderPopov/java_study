package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by Alex on 10/25/2016.
 */
public class SynchronizationDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        new Thread(new Producer(list)).start();
        new Thread(new Consumer(list)).start();
    }

    static class Producer implements Runnable {
        private List<String> messages;

        public Producer(List<String> messages) {
            this.messages = messages;
        }

        @Override
        public void run() {
            System.err.println("Producer run() started.");
            String[] arr = {"one", "two", "three", "four", "five", "end"};
            for (String s : arr) {
                System.out.println("Adding '" + s + "' to the list");
                synchronized (messages) {
                    messages.add(s);
                }
                try {
                    sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {}
            }
            System.err.println("Producer run() finished.");
        }
    }

    static class Consumer implements Runnable {
        private List<String> messages;

        public Consumer(List<String> messages) {
            this.messages = messages;
        }

        @Override
        public void run() {
            System.err.println("Consumer run() started.");
            while (true) {
                synchronized (messages) {
                    if (messages.isEmpty()) continue;
                    if (messages.get(0).equalsIgnoreCase("end")) break;
                    System.out.println("Readed and deleted '" + messages.remove(0) + "'");
                }
            }
            System.err.println("Consumer run() finished.");
        }
    }
}

