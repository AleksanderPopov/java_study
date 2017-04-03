package com.alexstudy.courses.onlinejavalessons.advanced.generics;

/**
 * Created by Alex on 4/1/2017.
 */
public class Product<T extends Product> implements Comparable<T> {
    String name;
    int price;

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
