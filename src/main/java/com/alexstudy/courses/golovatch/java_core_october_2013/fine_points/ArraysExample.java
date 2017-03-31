package com.alexstudy.courses.golovatch.java_core_october_2013.fine_points;

/**
 * Created by apop on 3/29/2017.
 */
public class ArraysExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(java.util.Arrays.toString(arr));

        int[][] arr1 = {{1,2}, {3,4}};
        System.out.println(java.util.Arrays.deepToString(arr1));
    }
}
