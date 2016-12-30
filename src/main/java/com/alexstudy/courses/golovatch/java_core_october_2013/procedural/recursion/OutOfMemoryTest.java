package golovatch.courses.proc.recursion;

/**
 * Created by apop on 7/15/2016.
 */
public class OutOfMemoryTest {
    private static void heapOutOfMemory() {
        Object[] arr = new Object[1000000];
        int i = 0;
        while (true) {
            arr[i] = new HeavyClass();
            System.out.println(i++);
        }
    }

    public static void main(String[] args) {
//        HeavyClass heavyClass = new HeavyClass();
//        heavyClass.f();

        Object[] arr = new Object[1000000];
        int i = 0;
        while (true) {
            arr[i] = new HeavyClass();
            System.out.println(i++);
        }
    }
}
