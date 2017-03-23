package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples.virtual_method;

/**
 * Created by apop on 3/23/2017.
 */
public class VirtualMethods {
    public static void main(String[] args) {
        send(new Child());
    }

    static void send(Parent p) {
        p.call();
    }
}
class Parent {
    void call() {
        System.out.println("parent");
    }
}
class Child extends Parent {
    void call() {
        System.out.println("child");
    }
}
