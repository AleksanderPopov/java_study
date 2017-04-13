package com.alexstudy.courses.golovatch.design_patterns.creational.builder;

/**
 * Created by apop on 4/12/2017.
 */
public class User {
    private final int age;
    private final String name;
    private final int weigth;

    private User(UserBuilder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.weigth = builder.weigth;
    }

    public static UserBuilder builder() { return new UserBuilder(); }

    public static class UserBuilder {
        private int age;
        private String name;
        private int weigth;

        public UserBuilder() {
        }

        public UserBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withWeight(int weight) {
            this.weigth = weight;
            return this;
        }

        public User build() { return new User(this); }
    }
}
