package Section10.LinkedLists.Challange.Challange4;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;
    
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) {
            return false;
        }
        
        Branch branch = new Branch(branchName);
        branches.add(branch);
        return true;
    }
    
    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialTransaction);
        }
        return false;
    }
    
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }
    
    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }
    
    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branchName);
            
            ArrayList<Customer> customers = branch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (i+1) + "]");
                
                if (printTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + String.format("%.2f", transactions.get(j)));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
