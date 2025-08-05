package Section6.Input;

import java.util.Scanner;
public class example2 {
    public static void main(String[] args) {
        System.out.println("Bir sayı girin veya çıkmak için harf girin");
        Scanner scanner = new Scanner(System.in);

        double max = 0;
        double min = 0;
        int loopCount = 0;

        while(true){
            System.out.println("Girdi "+ (loopCount+1));
            String input = scanner.nextLine();
            try{
                double validNum = Double.parseDouble(input);
                if (validNum>max){
                    max = validNum;
                }
                else if(validNum<min){
                    min = validNum;
                }
                loopCount++;
            }catch(NumberFormatException exception){
                break;
            }
        }
        if(loopCount>0)
        System.out.println("" + loopCount+1 + " tane girdi içerinden Min: "+ min + " Max: " + max  + "");
        else
        System.out.println("Loop yapılmadı");
    }

}
