package Section4;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Faruk!");
        System.out.println("Hello World!");

    /*     boolean isAlien = false;
            if (!isAlien){
                System.out.println("You are not an Alien!");
            }
    */

    /*    int topScore = 80;
        if(topScore<=100){
            System.out.println("You got the high score!");
        }
        int secondTopScore=60;
        if((topScore > secondTopScore) && (topScore < 100)){
            System.out.println("Greater than second top score!");
        }
        if((topScore>90) || (secondTopScore<=90)){
            System.out.println("Either or both True!");
        }
    */
    /*    int newValue = 50;
        if (newValue==50){
            System.out.println("This is True");
        }

        boolean isCar= false;
        if (!isCar){
            System.out.println("This is not supposed to happen");
        }
    */
    /*    String makeofCar= "Volkswagen";
        boolean isDomestic = makeofCar == "Volkswagen" ? false : true;

        if (isDomestic){
            System.out.println("This car is domestic to our country");
        }

        String s = (isDomestic) ? "This car is domestic" : "This car is not domestic";

        System.out.println(s);
    */
        double myFirstVal = 20.00d;
        double mySecondVal = 80.00d;
        double myValTotal = (myFirstVal + mySecondVal) * 100d;

        System.out.println("myValTotal: "+ myValTotal);

        double theRemainder= myValTotal % 40;
        System.out.println(theRemainder);

        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        System.out.println("isNoRemainder:  "+ isNoRemainder);
        if(!isNoRemainder){
            System.out.println("Got some Remainder!");
        }
    }
}
