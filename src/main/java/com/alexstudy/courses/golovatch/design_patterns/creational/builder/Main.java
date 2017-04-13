package com.alexstudy.courses.golovatch.design_patterns.creational.builder;

/**
 * Created by apop on 4/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        User.UserBuilder builder = User.builder();
        User alex = builder
                .withAge(24)
                .withName("Alex")
                .withWeight(79)
                .build();
    }
}
