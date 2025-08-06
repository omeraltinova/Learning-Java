package Section7.OOPpart1.example;

public class ComplexNumber {
    private double real,imaginary;

    public ComplexNumber(double real,double imaginary){
        this.real=real;
        this.imaginary=imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
    public void add(double real,double imaginary){
        this.real+=real;
        this.imaginary+=imaginary;
    }
    public void add(ComplexNumber a){
        this.real+=a.getReal();
        this.imaginary+=a.getImaginary();
    }
    public void subtract(double real,double imaginary){
        this.real-=real;
        this.imaginary-=imaginary;
    }
    public void subtract(ComplexNumber a){
        this.real-=a.getReal();
        this.imaginary-=a.getImaginary();
    }
}
