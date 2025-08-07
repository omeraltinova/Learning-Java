package Section7.OOPpart1.TheObject.example;

public class Test {
    public static void main(String[] args) {
        Employee tim = new Employee("Tim","11/11/1985","01/01/2025");
        System.out.println(tim);
        System.out.println("Age " + tim.getAge());
        System.out.println("Pay " + tim.collectPay());

        SalariedEmployee joe = new SalariedEmployee("Joe","11/11/1990","03/03/2020",10000);
        System.out.println(joe);
        System.out.println("Joe paycheck "+ joe.collectPay());
        joe.retire();
        System.out.println("Joe paycheck "+ joe.collectPay());

        HourlyEmployee mary = new HourlyEmployee("Mary","05/05/1970","03/03/2021",15);
        System.out.println(""+ mary.collectPay());
        System.out.println("" + mary.getDoublePay());

    }

}
