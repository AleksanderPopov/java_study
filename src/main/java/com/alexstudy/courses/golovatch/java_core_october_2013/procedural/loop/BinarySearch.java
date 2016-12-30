package golovatch.courses.proc.loop;

/**
 * Created by Alex on 7/10/2016.
 */
public class BinarySearch {
    public static int binarySearch(long[] arr, long value) {
        return binarySearch(arr,0, arr.length-1, value);
    }

    public static int binarySearch(long[] arr, long startIndex, long endIndex, long value) {
        if (arr == null) throw new NullPointerException();
        checkRanges(startIndex, endIndex);

        //binary search
        while (startIndex <= endIndex) {
            int midIndex = (int) (endIndex + startIndex) >>> 1;
            long midValue = arr[midIndex];

            if (value == midValue) return midIndex; //key found
            else if (value > midValue) startIndex = midIndex + 1;
            else endIndex = midIndex - 1;
        }
        //key not found
        return -1;
    }

    private static void checkRanges(long startIndex, long endIndex) {
        if (startIndex > endIndex || startIndex == endIndex)
            throw new IllegalArgumentException("Expected: endIndex > startIndex\n" +
                    "but was: startIndex = " + startIndex + ", endIndex = " + endIndex);
        if (startIndex < 0 || endIndex < 0)
            throw new IllegalArgumentException("Expected: endIndex > startIndex\n" +
                    "but was: startIndex = " + startIndex + ", endIndex = " + endIndex);
    }

    public static void main(String[] args) {
        long[] arr = new long[1000000];
        for (int i = 0; i < arr.length; i++) arr[i] = i * 2;

        System.out.println("--------------------------");
        int keyValue = 1024;
        int binaryIndex = binarySearch(arr, keyValue);
        System.out.println("Founded keyValue = '" + keyValue + "' at index '" + binaryIndex + "'");
        System.out.println("--------------------------");
        System.out.println("arr[binaryIndex] == keyValue is " + (arr[binaryIndex] == keyValue));
        System.out.println("--------------------------");
    }
}
