package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_9.autoboxing_challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 10/12/2016.
 */
public class Bank {
    private List<Branch> branches = new ArrayList<>();

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public void addTransaction(String branchName, String customerName, double transaction) {
        getBranchByName(branchName).addTransaction(customerName, transaction);
    }

    public void printCustomers(String branchName, boolean isPrintTransactions) {
        getBranchByName(branchName).printCustomers(isPrintTransactions);
    }

    private Branch getBranchByName(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(name)) return branch;
        }
        return null;
    }

}
