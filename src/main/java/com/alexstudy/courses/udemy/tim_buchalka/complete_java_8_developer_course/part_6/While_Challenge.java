package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_6;

/**
 * Created by Alex on 10/9/2016.
 */
public class While_Challenge {

    public static void main(String[] args) {
        int number = 5;
        int finishNumber = 20;
        int evenNumberCount = 0;
        while(number <= finishNumber) {
            if(!isEvenNumber(number)) {
                number++;
                continue;
            }
            System.out.println("Even number " + number);
            number++;
            evenNumberCount++;
        }
    }

    private static boolean isEvenNumber(int i) {
        return i % 2 == 0;
    }

    // Modify the while code above
    // Make it also record the total number of even numbers it has found
    // and break once 5 are found
    // and at the end, display the total number of even numbers found


    // Create a method called isEvenNumber that takes a parameter of types int
    // Its purpose is to determine if the argument passed to the method is
    // an even number or not.
    // return true if an even number, otherwise return false;
}
