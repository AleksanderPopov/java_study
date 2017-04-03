package com.alexstudy.courses.golovatch.java_core_october_2013.oop.labs.nested_employee;

import com.alexstudy.courses.golovatch.java_core_october_2013.oop.labs.plain_address.Address;
import com.alexstudy.courses.golovatch.java_core_october_2013.oop.labs.plain_phone.Phone;

/**
 * Created by apop on 4/3/2017.
 */
public class NestedEmployee {
    private int age;
    private String name;
    private Address address;
    private Phone phone;

    public NestedEmployee(int age, String name, Address address, Phone phone) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("NestedEmployee[age='%d', name='%s', address='%s', phone='%s']", age, name, address.toString(), phone.toString());
    }

    public static void main(String[] args) {
        System.out.println(new NestedEmployee(21, "alex", new Address("usa", "city", "street", 21), new Phone(123, 4567890)).toString());
    }
}
