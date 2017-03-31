package com.alexstudy.courses.onlinejavalessons.advanced.collections.set;

import java.util.*;

/**
 * Created by apop on 3/31/2017.
 */
public class TreeSetExample {
    public static void main(String[] args) {
        NavigableSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        System.out.println(getNextElem(integers, 3));

        System.out.println(getPrevElems(integers, 6));
    }

    static Integer getNextElem(NavigableSet<Integer> integers, Integer elem) {
        return integers.higher(elem);
    }

    static Set<Integer> getPrevElems(NavigableSet<Integer> integers, Integer elem) {
        return integers.headSet(elem);
    }
}
