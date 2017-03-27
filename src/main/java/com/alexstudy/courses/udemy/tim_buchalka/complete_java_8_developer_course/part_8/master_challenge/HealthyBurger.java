package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_8.master_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class HealthyBurger extends Burger {
    HealthyBurger(String... additions) {
        this.breadType = "Brown rye bread roll";
        this.minAdditions = 2;
        this.maxAdditions = 6;

        if (additions.length > this.maxAdditions || additions.length < this.minAdditions)
            throw new IllegalArgumentException("You can choose from 2 to 6 additions");
        this.additions = additions;
        System.out.print("You have ordered Base Burger with ");
        for (int a = 0; a < additions.length; a++) {
            if (a != additions.length - 1) System.out.print(additions[a] + ", ");
            else System.out.print(additions[a] + ".\n");
        }
    }

    @Override
    protected int getPrice() {
        return 20 + this.additions.length * 5;
    }
}