package Section9.Array.Using.Challange;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] s1 = getRandomArray(10);
        int[] s2 = new int[10];
        int[] s3 = sortIntegers(s1);



        System.out.println(Arrays.toString(s1));
        Arrays.sort(s1);

        for(int i = 0;i<s1.length;i++){
            s2[i] = s1[s1.length-i-1];
        }
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
        System.out.println(Arrays.toString(s3));


    }

    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i = 0;i<len;i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
    
    // Bubble sort algoritması kullanarak integer array'i sıralayan metod
    private static int[] sortIntegers(int[] array) {
        // Array'in kopyasını oluştur (orijinali değiştirmemek için)
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true; // Değişim olup olmadığını kontrol etmek için
        int temp; // Geçici değişken yer değiştirme için
        
        // Flag false olana kadar döngüye devam et
        while (flag) {
            flag = false; // Her iterasyonda false yap
            // Array'in sondan bir öncesine kadar git
            for (int i = 0; i < sortedArray.length - 1; i++) {
                // Eğer sıradaki eleman daha büyükse yer değiştir
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true; // Değişim olduğunu işaretle
                }
            }
        }
        
        return sortedArray;
    }
}
