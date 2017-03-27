package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_6;

/**
 * Created by Alex on 10/9/2016.
 */
public class For_Challenge {
    public static void main(String[] args) {
        int[] test = new int[100];
        for (int i = 1; i < test.length; i++) {
            test[i-1] = i;
        }
        printPrime(test);
    }

    private static void printPrime(int[] arr) {
        int primeCount = 0;
        for (int i = 0; i < arr.length & primeCount < 3; i++) {
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
                primeCount++;
            }
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
