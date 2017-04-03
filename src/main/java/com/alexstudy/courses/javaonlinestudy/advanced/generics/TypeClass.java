package com.alexstudy.courses.javaonlinestudy.advanced.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alex on 4/1/2017.
 */
public class TypeClass<T> {
    public <S> void test(Collection<S> collection) {
        collection.forEach(System.out::println);
    }

    public void test(List<Integer> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        TypeClass<Object> typeClass = new TypeClass<>();
        List<String> list = Arrays.asList("val", "var");
        typeClass.test(list);
    }
}
