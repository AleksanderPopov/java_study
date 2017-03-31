package com.alexstudy.courses.golovatch.java_core_october_2013.fine_points;

/**
 * Created by apop on 3/29/2017.
 */
public class VariablesExample {
    int i;
    boolean b;
    Object o;
    public static void main(String[] args) {

        // local variables
        int i;
//        System.out.println(i); NO!!!
        int[] arr = new int[16];
        System.out.println(arr[0]);
        boolean[] arr1 = new boolean[16];
        System.out.println(arr1[0]);
        Object[] arr2 = new Object[16];
        System.out.println(arr2[0]);
    }
}
