package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_9.autoboxing_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 10/12/2016.
 */
public class Customer {
    private String name;
    private List<Double> transactions = new ArrayList<>();

    public Customer(String name, Double... transactions) {
        this.name = name;
        Collections.addAll(this.transactions, transactions);
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return toString(false);
    }

    public String toString(boolean isPrintTransactions) {
        if (isPrintTransactions) return name + " " + transactions.size();
        else return name;
    }
}
