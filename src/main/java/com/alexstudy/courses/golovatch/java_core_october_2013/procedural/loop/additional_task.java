package golovatch.courses.proc.loop;

/**
 * Created by apop on 7/18/2016.
 */
public class additional_task {
    public static void main(String[] args) {
        allDifference(9999);
    }

    private static void allDifference(int to) {
        int leftIndex = 0;
        int rightIndex = 0;
        String tmp;
        for (int i = 0; i < to; i++) {
            tmp = Integer.toString(i);
            if (i % 11 == 0) continue;
            for (int j = 0; j < tmp.length() - 1; j++ ) {
                leftIndex = j;
                rightIndex = tmp.lastIndexOf(tmp.charAt(j));
                if (leftIndex != rightIndex) break;
            }
            if (leftIndex != rightIndex) continue;
            System.out.print(" " + i);
        }
    }
}
