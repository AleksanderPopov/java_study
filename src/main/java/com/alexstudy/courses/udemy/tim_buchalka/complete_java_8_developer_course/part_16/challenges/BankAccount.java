package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_16.challenges;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by apop on 4/5/2017.
 */
public class BankAccount {
    private final String name;
    private float balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(float money) throws InterruptedException {
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
            this.balance += money;
        } finally {
            lock.unlock();
        }
    }

    public float witdraw(float money) throws InterruptedException {
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
            this.balance += money;
            return money;
        } finally {
            lock.unlock();
        }
    }

    public String getAccountNumber() {
        return this.name;
    }

    public void printAccountNumber() {
        System.out.println("Account number: " + this.name);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
