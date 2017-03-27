package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_8.composition_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf("wood", new Dimension(10, 10, 5), true);
        TV tv = new TV("Panasonic", true, new Resolution(1364, 768), false);

        BedRoom bedRoom = new BedRoom(shelf, tv);
//        bedRoom.getShelf().getWear();
        bedRoom.getDressed();
    }
}
