package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_9.arraylist_challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 10/12/2016.
 */
public class PhoneBook {
    private List<Contact<String, String>> book = new ArrayList<>();

    public void addContact(Contact contact) {
        book.add(contact);
        System.out.println(contact.getName() + " - " + contact.getPhoneNumber() + " added to book.");
    }

    public void removeContactByName(String name) {
        if (isContainName(name)) book.remove(getIndexByName(name));
        else System.out.println("There is no contact with '" + name + "' name.");
    }

    public void removeContactByPhone(String phone) {
        if (isContainPhone(phone)) book.remove(getIndexByPhone(phone));
        else System.out.println("There is no contact with '" + phone + "' phone.");
    }

    public void editContactByName(String name, Contact contact) {
        if (isContainName(name)) book.set(getIndexByName(name), contact);
        else System.out.println("There is no contact with '" + name + "' name.");
    }

    public void editContactByPhone(String phone, Contact contact) {
        if (isContainName(phone)) book.set(getIndexByPhone(phone), contact);
        else System.out.println("There is no contact with '" + phone + "' phone.");
    }

    public void printContacts() {
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i).toString());
        }
    }

    private boolean isContainName(String name) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i) == null) break;
            if (book.get(i).getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    private boolean isContainPhone(String phoneNumber) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i) == null) break;
            if (book.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) return true;
        }
        return false;
    }

    private int getIndexByName(String name) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i) == null) break;
            if (book.get(i).getName().equalsIgnoreCase(name)) return i;
        }
        return -1;
    }

    private int getIndexByPhone(String phone) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i) == null) break;
            if (book.get(i).getPhoneNumber().equalsIgnoreCase(phone)) return i;
        }
        return -1;
    }
}
