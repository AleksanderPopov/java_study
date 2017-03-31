package com.alexstudy.courses.onlinejavalessons.advanced.collections.set;

import java.util.*;

/**
 * Created by apop on 3/31/2017.
 */
public class LinkedHashSetExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>(5, 1, true);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "e");
        map.put(0, "f");

        System.out.println(map);

        map.get(3);
        map.get(5);
        map.get(1);

        System.out.println(map);
    }
}
