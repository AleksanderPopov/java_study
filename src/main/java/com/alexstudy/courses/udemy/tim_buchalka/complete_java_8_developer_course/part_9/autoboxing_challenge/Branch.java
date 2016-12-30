package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_9.autoboxing_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 10/12/2016.
 */
public class Branch {
    private String name;
    private List<Customer> customers = new ArrayList<>();

    public Branch(String name, Customer... customers) {
        this.name = name;
        Collections.addAll(this.customers, customers);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTransaction(String name, double transactionValue) {
        getCustomerByName(name).addTransaction(transactionValue);
    }

    public void printCustomers(boolean isPrintTransactions) {
        for (Customer customer : customers) {
            System.out.println(customer.toString(isPrintTransactions));
        }
    }

    public String getName() {
        return name;
    }

    private Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) return customer;
        }
        return null;
    }
}
