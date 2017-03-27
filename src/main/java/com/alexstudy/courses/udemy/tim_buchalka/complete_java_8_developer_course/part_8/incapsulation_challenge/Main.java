package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_8.incapsulation_challenge;

/**
 * Created by Alex on 10/11/2016.
 */

/**
 * Create a class and demonstate proper encapsulation techniques
 * the class will be called Printer
 * It will simulate a real Computer Printer
 * It should have fields for the toner Level, number of pages printed, and
 * also whether its a duplex printer (capable of printing on both sides of the paper).
 * Add methods to fill up the toner (up to a maximum of 100%), another method to
 * simulate printing a page (which should increase the number of pages printed).
 * Decide on the scope, whether to use constructors, and anything else you think is needed.
 */


public class Main {
    public static void main(String[] args) {
        Printer simplePrinter = new Printer(false);
        Printer duplexPrinter = new Printer(true);

        for (int i = 0; i < 110; i++) {
            simplePrinter.print();
        }
        for (int i = 0; i < 30; i++) {
            duplexPrinter.print();
        }

        simplePrinter.fillToner(100);
        duplexPrinter.fillToner(90);
    }
}
