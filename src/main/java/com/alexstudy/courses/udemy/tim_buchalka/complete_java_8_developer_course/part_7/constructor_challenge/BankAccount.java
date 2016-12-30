package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_7.constructor_challenge;

/**
 * Created by Alex on 10/9/2016.
 */

/**
 * Create a new class for a bank account
 * Create fields for the account number, balance, customer name, email and phone number.
 * <p>
 * Create getters and setters for each field
 * Create two additional methods
 * 1. To allow the customer to deposit funds (this should increment the balance field).
 * 2. To allow the customer to withdraw funds. This should deduct from the balance field,
 * but not allow the withdrawal to complete if their are insufficient funds.
 * You will want to create various code in the Main class (the one created by IntelliJ) to
 * confirm your code is working.
 * Add some System.out.println's in the two methods above as well.
 */

public class BankAccount {
    private int accNumber;
    private String customerName;
    private String customerEmail;
    private int phonenumber;
    private int balance;

    public BankAccount() {
        this(0, null, null, 0, 0);
    }

    public BankAccount(int accNumber, String customerName, String customerEmail, int phonenumber, int balance) {
        this.accNumber = accNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phonenumber = phonenumber;
        this.balance = balance;
    }

    public void deposite(int deposit) {
        balance += deposit;
    }

    public int witdraw(int witdraw) {
        if (balance < witdraw) {
            System.out.println("Not enough money on the balance.");
            return 0;
        } else {
            balance -= witdraw;
            return witdraw;
        }
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
