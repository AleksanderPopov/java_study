package golovatch.courses.proc.loop;

import java.util.Arrays;

/**
 * Created by Alex on 7/10/2016.
 */
public class bubble_sort_inverted {

    /*
    usual bubble sort with modification 'arr.length - k - 1'
    (second loop does not go to the end if its not first iteration, cause in the end there already maxR element)
    */
    public static int[] bubble_sort(int[] arr) {
        int tmp;

        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length - 1 - k; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] bubble_sort_inverted(int[] arr) {
        int tmp;
        for (int k = 0; k < arr.length; k++) {
            for (int i = arr.length - 1; i > 0 + k; i--) {
                if (arr[i] < arr[i - 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] selection_sort(int[] arr) {
        int minValueIndex;
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            minValueIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minValueIndex]) minValueIndex = j;
            }
            tmp = arr[i];
            arr[i] = arr[minValueIndex];
            arr[minValueIndex] = tmp;
        }
        return arr;
    }

    public static int[] insertion_sort(int[] arr) {
        //if arr contaion only one cell, it is sorted already
        if (arr.length == 1) return arr;
        int tmp;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr1 = {9,8,7,6,5,4,3,2,1};
        int[] arr1 = {2, 6, 7, 8, 1, 2, 3, 5, 8, 9};

        System.out.println("------------------------------");
        System.out.println(Arrays.toString(arr1));
        System.out.println("------------------------------");

//        bubble_sort(arr1);
//        bubble_sort_inverted(arr1);
//        selection_sort(arr1);
        insertion_sort(arr1);

        System.out.println(Arrays.toString(arr1));
        System.out.println("------------------------------");

    }
}
