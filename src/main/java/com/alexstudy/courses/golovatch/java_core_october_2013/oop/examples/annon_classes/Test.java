package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples.annon_classes;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by Alex on 3/26/2017.
 */
public class Test {
    {
        Map map = new HashMap() {{put("A", 4); put("B", 2);}};

    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<String> strings = Arrays.asList("a", "b", "c");

        integers.stream().flatMap(i -> strings.stream().map(s -> Arrays.asList(i, s))).forEach(System.out::println);
    }
}
