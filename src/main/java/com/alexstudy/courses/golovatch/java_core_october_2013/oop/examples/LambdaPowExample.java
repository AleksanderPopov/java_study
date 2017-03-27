package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by apop on 3/27/2017.
 */
public class LambdaPowExample {
    public static void main(String[] args) {

        List<String> elements = Arrays.asList("a", "b");
        pow(elements, 3).forEach(System.out::println);
    }

    private static <T> Stream<List<T>> pow(List<T> elements, int pow) {
        if (pow == 1) {
            return elements.stream().map(Arrays::asList);
        } else {
            return pow(elements, pow - 1).flatMap(e -> elements.stream().map(Arrays::asList).map(e1 -> concat(e, e1)));
        }
    }

    private static <T> List<T> concat(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }
}
