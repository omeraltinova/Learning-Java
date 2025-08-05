package Section7.OOPpart1.example;

public class Account {
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String number;


    public Account(){
        this("54321",900,"Default","Default","Default");
        System.out.println("Empty call");
    }
    public Account(String number,double balance,String customerName,String customerEmail,String customerPhone){
        System.out.println("Constructor with parameters called!");
        this.number=number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail= customerEmail;
        this.customerPhone = customerPhone;
    }

    public Account(String customerName, String customerEmail, String customerPhone) {
        this("999999",100.55,customerName,customerEmail,customerPhone);
//        this.customerName = customerName;
//        this.customerEmail = customerEmail;
//        this.customerPhone = customerPhone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        System.out.println("Account balance is set to " + balance);
    }
    public void deposit(double balance) {
        setBalance(getBalance() + balance);
    }
    public void withdraw(double balance){
        if(getBalance()-balance<0){
            System.out.println("You can't withdraw money");
        }
        else{
            setBalance(getBalance()-balance);
            System.out.println("Remaining balance: " + getBalance());
        }
    }
}
