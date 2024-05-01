package Section5.MethodOverloading.Challenge;

public class Main {
    public static void main(String[] args) {
        System.out.println("5ft 8 inch " + convertToCentimeter(5,8)+"cm");
        System.out.println("68 inch "+ convertToCentimeter(68)+"cm");
    }


    public static double convertToCentimeter(int height){
        return(2.54*height);
    }
    public static double convertToCentimeter(int feet,int height){
        int total = ((feet*12) + height);
        return(convertToCentimeter(total));
    }
}
