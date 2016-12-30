package org.stepic.java.chapter3;

/**
 * Created by Alex on 7/9/2016.
 */
public class TestComplexNumber {
    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(5, 10);
        ComplexNumber number2 = new ComplexNumber(5, 10);
        ComplexNumber number3 = new ComplexNumber(50, 100);

        System.out.println(number1.toString());
        System.out.println(number2.toString());
        System.out.println(number3.toString());

        System.out.println("number1.equals(number2) is " + number1.equals(number2));
        System.out.println("number2.equals(number3) is " + number2.equals(number3));

        System.out.println("Hashcode of number1 is " + number1.hashCode());
        System.out.println("Hashcode of number2 is " + number2.hashCode());
        System.out.println("Hashcode of number3 is " + number3.hashCode());

        System.out.println("number1.hashCode() == number2.hashCode() is " + (number1.hashCode() == number2.hashCode()));
        System.out.println("number2.hashCode() == number3.hashCode() is " + (number2.hashCode() == number3.hashCode()));
        String s = "Alex";
        int hash = s.hashCode();
        System.out.println(hash);
    }
}
