package Section7.OOPpart1.example;

public class example {
    public static void main(String[] args) {
        Account bobsAccount = new Account();
       // Account bobsAccount = new Account("12345",500,"Bob Brown","myemail@bob.com","(087) 123-4567");
//        bobsAccount.setNumber("12345");
//        bobsAccount.setBalance(1000.00);
//        bobsAccount.setCustomerName("Bob Brown");
//        bobsAccount.setCustomerEmail("myemail@bob.com");
//        bobsAccount.setCustomerPhone ("(087) 123-4567");
        bobsAccount.withdraw(100.0);
        bobsAccount.deposit(250);
        bobsAccount.withdraw(50);
        bobsAccount.withdraw(200);
        bobsAccount.withdraw(1000);

        Account timsAccount = new Account("Tim","test","0000");
        System.out.println(timsAccount.getNumber()+ timsAccount.getCustomerPhone()+ timsAccount.getCustomerName());


    }

}
