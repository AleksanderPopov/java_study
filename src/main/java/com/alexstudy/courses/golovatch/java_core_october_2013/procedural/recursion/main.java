package golovatch.courses.proc.recursion;

/**
 * Created by Alex on 7/12/2016.
 */
public class main {
    private static int fib(int index) {
        if (index < 0) throw new IllegalArgumentException("Expected: number of fib number is positive" +
                "\nbut was: " + index);
        if (index == 0) return 0;
        if (index == 1) return 1;
        return (fib(index-1) + fib(index - 2));
    }


    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
