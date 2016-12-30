package golovatch.courses.proc.loop;

import java.util.Arrays;

/**
 * Created by apop on 7/4/2016.
 */
public class array_inverted_optimization {
    private static void invertArray (String[] arr) {
        String tmp1;
        for (int i = arr.length / 2 + arr.length % 2, z = arr.length / 2 - 1; z >= 0; i++, z--) {
            tmp1 = arr[i];
            arr[i] = arr[z];
            arr[z] = tmp1;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        System.out.println(Arrays.toString(arr));
        invertArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
