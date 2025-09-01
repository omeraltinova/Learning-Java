package Section10.ArrayLists.Challange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 5;

        ArrayList<String> groceries = new ArrayList<>();

        while(value!=0){
            System.out.println("Please select something 0 - leave 1 - add with comas 2- remove with comas");
            value = scanner.nextInt();

            if(value==1){
                System.out.println("Please enter items");
                scanner.nextLine(); // nextInt()'ten kalan enter karakterini temizle
                
                String input = scanner.nextLine();
                String[] array = input.split(",");
                for(String data : array){
                    groceries.add(data);
                }
                groceries.sort(Comparator.naturalOrder());
                System.out.println("NEW LIST: " + groceries.toString());
            }
            else if(value == 2){
                System.out.println("Please enter items");
                scanner.nextLine(); // nextInt()'ten kalan enter karakterini temizle

                String input = scanner.nextLine();
                String[] array = input.split(",");
                for(String data : array){
                    groceries.remove(data);
                }
                groceries.sort(Comparator.naturalOrder());
                System.out.println("NEW LIST: " + groceries.toString());
            }
        }
    }
}
