package Section10.LinkedLists.Challange.Challange3;


import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions){

    public Customer(String name,double initialDeposit){
        this(name.toUpperCase(),new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }
}



public class Main {

    public static void main(String[] args) {
        Customer bob = new Customer("Bob",1000);

        System.out.println(bob);

        Bank bank = new Bank("A");
        bank.addNewCustomer("Jane",1000);
        System.out.println(bank);

        bank.addTransactions("Jane",-10.25);
        bank.addTransactions("Jane",-74.31);
        bank.printStatement("Jane");

        bank.addNewCustomer("Bob",250);
        bank.addTransactions("Bob",100);
        bank.printStatement("Bob");
    }
}

class Bank{
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name){
        this.name=name;
    }
    private Customer getCustomer(String customerName){
        for(var customer : customers){
            if(customer.name().equalsIgnoreCase(customerName)){
                return customer;
            }
        }
        System.out.println("Not found!");
        return null;
    }
    public void addNewCustomer(String name,double initialDeposit){
        if(getCustomer(name) == null){
            Customer customer = new Customer(name,initialDeposit);
            customers.add(customer);
            System.out.println("Customer added!");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
    public void addTransactions(String name,double amount){
        Customer customer = getCustomer(name);
        if(customer!=null){
            customer.transactions().add(amount);
        }
    }
    public void printStatement(String customerName){
        Customer customer = getCustomer(customerName);
        if(customer == null){
            return;
        }

        System.out.println("-".repeat(30));

        System.out.println("Name  "+ customer.name());
        System.out.println("Transactions : ");
        for(double d : customer.transactions()){
            System.out.printf("$%10.2f (%s)%n",d,d<0 ? "debit":"deposit");
        }
    }
}
