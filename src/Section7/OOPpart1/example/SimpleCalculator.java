package Section7.OOPpart1.example;

public class SimpleCalculator {
    private double firstNumber;
    private double secondNumber;

    public double getFirstNumber(){
        return firstNumber;
    }

    public void setFirstNumber(double number){
        this.firstNumber = number;
    }

    public double getSecondNumber(){
        return secondNumber;
    }

    public void setSecondNumber(double number){
        this.secondNumber = number;
    }
    public double getAdditionResult(){
        return firstNumber+secondNumber;
    }

    public double getSubtractionResult(){
        return firstNumber-secondNumber;
    }

    public double getMultiplicationResult(){
        return firstNumber*secondNumber;
    }

    public double getDivisionResult(){
        if(secondNumber==0) return 0;
        else return firstNumber/secondNumber;
    }
}
