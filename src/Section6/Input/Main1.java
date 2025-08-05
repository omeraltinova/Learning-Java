package Section6.Input;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        int currentYear = 2025;
        Scanner scanner = new Scanner(System.in);
        boolean validDOB = false;
        int age = 0;
        do {
            System.out.println("Doğum yılınızı girin (>= " + (currentYear - 125) + " ve <= " + currentYear + "):");
            try{ 
                age = checkData(currentYear, scanner.nextLine());
            validDOB = age < 0 ? false : true; }
            catch(NumberFormatException badUserData){
                System.out.println("Karakter girmek yasaktır.");
            }
        } while (!validDOB);
        System.out.println("Yani " + age + " yaşındasınız.");

}
    public static int checkData(int currenyYear,String dateBirth) {
        int dob = Integer.parseInt(dateBirth);
        int minimumYear = currenyYear - 125;

        if(dob< minimumYear || dob > currenyYear){
            return -1;
        }
        else{
            return currenyYear-dob;
        }
    }

}