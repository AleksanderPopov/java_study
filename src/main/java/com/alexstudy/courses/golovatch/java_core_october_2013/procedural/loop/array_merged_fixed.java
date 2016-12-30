package golovatch.courses.proc.loop;

import java.util.Arrays;

/**
 * Created by apop on 7/4/2016.
 */
public class array_merged_fixed {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] finalArray = new int[a1.length + a2.length];
        int counter1 = 0;
        int counter2 = 0;

        for (int finalCounter = 0; finalCounter < finalArray.length; finalCounter++) {
            if (counter1 == a1.length) {
                System.arraycopy(a2, counter2, finalArray, finalCounter, (a2.length - counter2));
                break;
            } else if (counter2 == a2.length) {
                System.arraycopy(a1, counter1, finalArray, finalCounter, (a1.length - counter1));
                break;
            }

            if (a1[counter1] <= a2[counter2]) {
                finalArray[finalCounter] = a1[counter1];
                counter1++;
            } else if (a2[counter2] <= a1[counter1]) {
                finalArray[finalCounter] = a2[counter2];
                counter2++;
            }
        }
        return finalArray;
    }

    public static void main(String[] args) {
        //creating arrays with some lenth
        int[] a1 = new int[10];
        int[] a2 = new int[100];

        //filling them some sorted values
        for (int i = 0; i < a1.length; i++) a1[i] = i;
        for (int i = 0; i < a2.length; i++) a2[i] = i*2;

        //print how arrays look like before merge, and after
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(mergeArrays(a1, a2)));
    }
}
