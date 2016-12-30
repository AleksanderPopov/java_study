package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_7.constructor_challenge;

/**
 * Created by Alex on 10/9/2016.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.deposite(1000);
        ba.witdraw(1000);
        ba.witdraw(1000);
    }
}
