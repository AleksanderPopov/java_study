package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples.fields;

/**
 * Created by apop on 3/23/2017.
 */
public class Fields {
    public static void main(String[] args) {
        send(new Child());
    }
    static void send(Parent p) {
        System.out.println(p.call);
    }
}

class Parent {
    String call = "parent";
}

class Child extends Parent {
    String call = "child";
}