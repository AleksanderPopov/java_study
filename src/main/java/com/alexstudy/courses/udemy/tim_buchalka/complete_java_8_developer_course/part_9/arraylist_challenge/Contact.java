package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_9.arraylist_challenge;

/**
 * Created by Alex on 10/12/2016.
 */
public class Contact<F, S> {
    private F name;
    private S phoneNumber;

    public Contact(F name, S phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(S phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public F getName() {
        return name;
    }

    public S getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public java.lang.String toString() {
        return "Contact " +
                "name=" + name +
                ", phone number=" + phoneNumber;
    }
}
