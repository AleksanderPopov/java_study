package golovatch.courses.proc.recursion;

/**
 * Created by apop on 7/15/2016.
 */
public class HeavyClass {
    private long[] arr;
    private int i = 0;
    public HeavyClass() {
        arr = new long[100000];
    }
    public void f() {
        long l1 = 0; long l2 = 0; long l3 = 0;
        long l4 = 0; long l5 = 0; long l6 = 0;
        long l7 = 0; long l8 = 0; long l9 = 0;
        System.out.println(i++);
        f();
    }
}
