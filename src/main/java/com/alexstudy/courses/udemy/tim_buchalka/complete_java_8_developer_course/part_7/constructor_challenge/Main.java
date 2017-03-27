package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_7.constructor_challenge;

/**
 * Created by Alex on 10/9/2016.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.deposite(1000);
        ba.witdraw(1000);
        ba.witdraw(1000);
    }
}
