package Section5.Statements;

public class Main {
    public static void main(String[] args) {
        int myVar = 50;

        myVar++;
        myVar--;

        System.out.println("This is a test");

        System.out.println("This is " + "another " + "still more ");

        myVar++;
        System.out.println("Var = " + myVar);

        if(myVar == 0){
            System.out.println("It's now zero");
        }
    }
}
