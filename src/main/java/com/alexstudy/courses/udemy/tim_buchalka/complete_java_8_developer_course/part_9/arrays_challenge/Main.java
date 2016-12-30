package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_9.arrays_challenge;

/**
 * Created by Alex on 10/12/2016.
 */

import java.util.Scanner;

/**
 * Create a program using arrays that sorts a list of integers in descending order.
 * Descending order is highest value to lowest.
 * In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
 * ultimately have an array with 106,81,26, 15, 5 in it.
 * Set up the program so that the numbers to sort are read in from the keyboard.
 * Implement the following methods - getIntegers, printArray, and sortIntegers
 * getIntegers returns an array of entered integers from keyboard
 * printArray prints out the contents of the array
 * and sortIntegers should sort the array and return a new array containing the sorted numbers
 * you will have to figure out how to copy the array elements from the passed array into a new
 * array and sort them and return the new sorted array.
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        printArray(test);
//        test = sortIntegers(test);
//        printArray(test);

        System.out.println("How many digits you want to see in array?");
        int arrSize = scanner.nextInt();

        int[] arr = getIntegers(arrSize);
        arr = sortIntegers(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (!(i == arr.length - 1)) System.out.print(",");
        }
        System.out.println("]");
    }

    // bubble sort
    private static int[] sortIntegers(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] getIntegers(int arrSize) {
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
