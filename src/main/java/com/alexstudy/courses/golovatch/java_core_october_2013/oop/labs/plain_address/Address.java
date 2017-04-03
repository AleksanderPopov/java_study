package com.alexstudy.courses.golovatch.java_core_october_2013.oop.labs.plain_address;

/**
 * Created by apop on 4/3/2017.
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private int houseNumber;

    public Address(String country, String city, String street, int houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String toString() {
        return String.format("Address[country='%s', city='%s', street='%s', house number = '%d']", country, city, street, houseNumber);
    }

    public static void main(String[] args) {
        System.out.println(new Address("usa", "california", "red lights", 666).toString());
    }
}
