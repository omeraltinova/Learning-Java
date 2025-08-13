package Section9.Array.VarArgs.Challange;

import jdk.jshell.EvalException;

import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

    }
    private static int readInteger(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter aintegers");
        int input = scanner.nextInt();

        return input;
    }

    private static int[] readElements(int value){
        Scanner scanner  = new Scanner(System.in);
        int[] array = new int[value];

        for(int i = 0;i<value;i++){
            System.out.println("Enter integers");
            int input = scanner.nextInt();
            array[i] = input;
        }

        return array;
    }
    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for(int el : array){
            if(el<min){
                min = el;
            }
        }
        return min;
    }
    private static void reverse(int[] array){
        int maxIndex = array.length-1;
        int halfLength = array.length/2;

        for(int i = 0;i<halfLength;i++){
            int temp = array[i];
            array[i] = array[maxIndex-1];
            array[maxIndex-1] = temp;
            System.out.printf("---> " + Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }
}
