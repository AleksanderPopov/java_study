package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_7.inheritance_challenge;

/**
 * Created by Alex on 10/9/2016.
 */
public class Car extends Vehicle {
    protected int passangersCount;
    protected int doorsCount;
    protected Category carCategory;
    protected PricePolicy pricePolicy;
    protected int maxSpeed;

    protected enum Category { A, B, C, D, E}
    protected enum PricePolicy {LOW, MIDDLE, HIGTH}
}


