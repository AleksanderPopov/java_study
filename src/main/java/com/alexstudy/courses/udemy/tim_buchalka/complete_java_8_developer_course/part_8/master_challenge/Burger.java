package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_8.master_challenge;

/**
 * Created by Alex on 10/11/2016.
 */

public abstract class Burger {
    protected String breadType;
    protected int minAdditions;
    protected int maxAdditions;
    protected String[] additions;

    protected abstract int getPrice();
}
