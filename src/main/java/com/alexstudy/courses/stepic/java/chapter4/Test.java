package org.stepic.java.chapter4;

/**
 * Created by Alex on 7/10/2016.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
//        Arrays.toString(new Throwable().getStackTrace());
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        return new Throwable().getStackTrace()[0].toString();
    }
}
