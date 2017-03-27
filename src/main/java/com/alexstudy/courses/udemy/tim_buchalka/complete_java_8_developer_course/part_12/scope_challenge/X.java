package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_12.scope_challenge;

/**
 * Created by Alex on 10/15/2016.
 */
public class X {
    private int x = 12;
    public void x(int x) {
        for (; this.x >= 0; this.x--) {
            System.out.println(x * this.x);
        }
    }
}
