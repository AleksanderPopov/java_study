package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 3/28/2017.
 */
public class NestedClassKeepsLinkToOuter {
    long[] arr = new long[Integer.MAX_VALUE / 1000];

    public static void main(String[] args) {
        List<SimpleClass> list = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            list.add(new NestedClassKeepsLinkToOuter().new SimpleClass() {
                @Override
                public void get() {

                }
            });
            System.out.println(list.size());
        }
    }

    abstract class SimpleClass {
        abstract void get();
    }
}

