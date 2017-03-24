package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples.nested_classes;

/**
 * Created by apop on 3/24/2017.
 */
public class XXX {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner0 = outer.new Inner();
        Outer.Inner inner1 = new Outer().new Inner();

        Outer.Inner
    }
}

class Outer {
    public int o = 0;
    class InnerA {
        int a = 1;
        public void print() {
            System.out.println(x * x);
        }
    }

    class InnerB {
        int b = 2;
        public void print() {
            System.out.println(x * x);
        }
    }
}
