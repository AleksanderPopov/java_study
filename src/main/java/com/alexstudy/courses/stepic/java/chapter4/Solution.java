package com.alexstudy.courses.stepic.java.chapter4;

/**
 * Created by Alex on 7/9/2016.
 */
public class Solution {
    public static double sqrt(double x) {
        if (x >= 0) return Math.sqrt(x);
        else throw new IllegalArgumentException("Expected non-negative number, got " + x);
    }
    public static void main(String[] args) {
        sqrt(25);
        sqrt(-1);
    }
}
