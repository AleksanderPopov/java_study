package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_16.challenges;

/**
 * Created by apop on 4/5/2017.
 */
public class Challenge {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount("12345-678", 1000.0F);

        Thread person1 = new Thread(new DepositWitdrawSimpleFlow(account, 300.00f, 50.00f));
        Thread person2 = new Thread(new DepositWitdrawSimpleFlow(account, 203.75f, 10.00f));
        person1.start();
        person2.start();
        person1.join();
        person2.join();

        System.out.println(account);
    }

    static class DepositWitdrawSimpleFlow implements Runnable {
        BankAccount account;
        private final float deposit;
        private final float witdraw;

        public DepositWitdrawSimpleFlow(BankAccount account, float deposit, float witdraw) {
            this.account = account;
            this.deposit = deposit;
            this.witdraw = witdraw;
        }

        @Override
        public void run() {
            try {
                this.account.deposit(deposit);
                this.account.witdraw(witdraw);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
