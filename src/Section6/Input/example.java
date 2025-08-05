package Section6.Input;

import java.util.Scanner;

public class example {

    public static void main(String[] args) {
        int number = 1, toplam = 0;
        Scanner scanner = new Scanner(System.in);
        while(number<6){
            System.out.println("Lütfen "+ number+". sayıyı giriniz");
            String input = scanner.nextLine();
            try {
                int sayi = Integer.parseInt(input);
                number++;
                toplam += sayi;
            } catch (NumberFormatException e) {
                System.out.println("Sayı dışında bir şey giremezsiniz!");
            }
        }
        System.out.println("Sayıların toplamı " + toplam);
        scanner.close();
    }

}
