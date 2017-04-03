package com.alexstudy.courses.javaonlinestudy.advanced.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alex on 4/1/2017.
 */
public class GenericExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List rawList = list;
        rawList.add(8);
        String s = list.get(0);
    }

    void copy(List<? extends Product> src, List<? super Product> dest) {
        for(Product p : src) { dest.add(p); }
    }

    void b() {
        List<Camera> cameras = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        copy(cameras, objects);
    }

}
