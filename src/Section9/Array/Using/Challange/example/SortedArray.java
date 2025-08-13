package Section9.Array.Using.Challange.example;

import java.util.Scanner;

public class SortedArray {
    // Kullanıcıdan belirtilen sayıda integer alan metod
    public int[] getIntegers(int size){
        Scanner scanner = new Scanner(System.in); 
        int[] newArray = new int[size];
        for(int i = 0; i < size; i++){
            System.out.println("Sayı girin:");
            newArray[i] = scanner.nextInt(); 
        }
        return newArray;
    }
    
    // Array'i yazdıran metod
    public void printArray(int[] array){
        for(int i = 0; i < array.length; i++){ 
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
    
    // Bubble sort ile büyükten küçüğe sıralayan metod
    public int[] sortIntegers(int[] array){
        int temp;
        boolean flag = true;
        int length = array.length; 
        
        while(flag){
            flag = false;
            for(int i = 0; i < length - 1; i++){ 
                if(array[i] < array[i+1]){ 
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp; 
                    flag = true;
                }
            }
        }
        return array;
    }
}
