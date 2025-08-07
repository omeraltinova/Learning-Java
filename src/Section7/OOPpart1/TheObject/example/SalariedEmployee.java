package Section7.OOPpart1.TheObject.example;

public class SalariedEmployee extends Employee{
    double annualSalary;
    boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double collectPay(){
        double paycheck = annualSalary/26;
        double adjustedPay = isRetired ? 0.9 * paycheck : paycheck;
        return  adjustedPay;
    }
    public void retire(){
        terminate("12/12/2025");
        isRetired=true;
    }
}
