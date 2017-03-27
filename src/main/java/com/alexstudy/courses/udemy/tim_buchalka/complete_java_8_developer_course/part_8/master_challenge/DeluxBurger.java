package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_8.master_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class DeluxBurger extends Burger {
    public DeluxBurger() {
        this.breadType = "Bread Roll Type";
        this.minAdditions = 2;
        this.maxAdditions = 2;
        this.additions = new String[2];
        this.additions[0] = "CocaCola";
        this.additions[1] = "Chips";
        System.out.print("You have ordered Base Burger with ");
        for (int a = 0; a < additions.length; a++) {
            if (a != additions.length - 1) System.out.print(additions[a] + ", ");
            else System.out.print(additions[a] + ".\n");
        }
    }


    @Override
    protected int getPrice() {
        return 40;
    }
}
