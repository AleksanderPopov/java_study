package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples.nested_classes;

/**
 * Created by apop on 3/24/2017.
 */
public class XXX {

    public void f() {
//        class MyRunnable implements Runnable {
//            @Override
//            public void run() {
//                System.out.println("runned");
//            }
//        }
//        new Thread(new MyRunnable()).start();
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("runned");
        }
    }).start();
    }

    public static void main(String[] args) {

        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("runned");
            }
        }

        new Thread(new MyRunnable()).start();
    }



}

