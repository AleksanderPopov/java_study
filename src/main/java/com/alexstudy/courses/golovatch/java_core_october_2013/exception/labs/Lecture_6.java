package golovatch.courses.exception.labs;

import java.util.Arrays;

/**
 * Created by apop on 8/5/2016.
 */
public class Lecture_6 {
    public static void main(String[] args) {
        try (X x1 = new X(1); X x2 = new X(2); X x3 = new X(3)) {
            System.err.println("try");
            throw new RuntimeException("catch", new RuntimeException("cause"));
        } catch (Throwable a) {
            System.err.println(a.getMessage());
            System.err.println(a.getCause().toString());
            System.err.println(Arrays.toString(a.getSuppressed()));
        } finally {
            System.err.println("finally");
        }
    }
}

class X implements AutoCloseable{
    int number;
    X(int aNumber) {
        number = aNumber;
        System.err.println("X " + number + " created");
//        throw new RuntimeException();
    }

    @Override
    public void close() {
        System.err.println("X " + number + " closed");
        throw new RuntimeException("close X" + number);
    }
}
