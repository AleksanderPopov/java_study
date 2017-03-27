package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_8.composition_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class Shelf {
    private String material;
    private Dimension dimension;
    private boolean hasWear;

    public Shelf(String material, Dimension dimension, boolean hasWear) {
        this.material = material;
        this.dimension = dimension;
        this.hasWear = hasWear;
    }

    public void getWear() {
        if (hasWear) System.out.println("Has some clothes, take one.");
        else System.out.println("There is no clothes available in the shelf");
    }

    public String getMaterial() {
        return material;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public boolean isHasWear() {
        return hasWear;
    }
}
