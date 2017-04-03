package com.alexstudy.courses.golovatch.java_core_october_2013.oop.labs.plain_phone;

/**
 * Created by apop on 4/3/2017.
 */
public class Phone {
    private final int code;
    private final int number;

    public Phone(int code, int number) {
        this.code = code;
        this.number = number;
    }

    @Override
    public String toString() {
        String stringNumber = String.valueOf(number);
        return String.format("Phone[(%s) %s-%s-%s]",
                String.valueOf(code), stringNumber.substring(0, 3), stringNumber.substring(3, 5), stringNumber.substring(5, 7));
    }

    public static void main(String[] args) {
        System.out.println(new Phone(777, 1234567));
    }
}
