package golovatch.courses.proc.recursion.labs;

import java.util.Arrays;
/**
 * Created by Alex on 7/17/2016.
 */
public class permutation {
    private static void permutation(int[] arr, int size) {
        if (size < 2) {
            System.out.println(Arrays.toString(arr));
        }
        else {
            for (int i = 0; i < size; i++) {
                swap(arr, i, size - 1 - i);
                permutation(arr,size - 1);
            }
        }
    }
    private static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, arr.length);
    }
}
