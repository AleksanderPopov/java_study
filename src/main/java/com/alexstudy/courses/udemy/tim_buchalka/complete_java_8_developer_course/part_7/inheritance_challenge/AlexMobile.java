package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_7.inheritance_challenge;

/**
 * Created by Alex on 10/9/2016.
 */
public class AlexMobile extends Car {

    AlexMobile(int year, String model, int passangersCount, int weight) {
        this.year = 2016;
        this.make = "AlexCorp";
        this.model = model;
        this.weight = weight;
        this.passangersCount = passangersCount;
        this.doorsCount = 2;
        this.maxSpeed = 1000;
        this.carCategory = Category.A;
        this.pricePolicy = PricePolicy.HIGTH;
    }
}
