package Section9.Array.Using;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        int[] array1 = getRandomArray(10);
//        for(int value : array1){
//            System.out.print(value + " ");
//        }
//        System.out.println();
//        Arrays.sort(array1);
//        System.out.println(Arrays.toString(array1));
//        int[] array2 = new int[10];
//        System.out.println(Arrays.toString(array2));
//        Arrays.fill(array2,3);
//        System.out.println(Arrays.toString(array2));

//        int[] array3 = getRandomArray(10);
//        System.out.println(Arrays.toString(array3));
//
//        int[] array4 = Arrays.copyOf(array3,array3.length);
//        Arrays.sort(array4);
//        System.out.println(Arrays.toString(array4));
//
//        int[] smallArray = Arrays.copyOf(array3,5);
//        System.out.println(Arrays.toString(smallArray));
//
//        int[] bigArray = Arrays.copyOf(array3,15);
//        System.out.println(Arrays.toString(bigArray));


        String[] sArray= {"Abel","Jane","Mark","Ralph","David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if(Arrays.binarySearch(sArray,"Mark")>=0){
            System.out.println("Found Mark!");
        }
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5,0};
        if(Arrays.equals(s1,s2)){
            System.out.println("Arrays are equal");
        }else System.out.println("Not equal");
    }

    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i = 0;i<len;i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
