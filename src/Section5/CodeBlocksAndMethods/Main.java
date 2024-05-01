package Section5.CodeBlocksAndMethods;

public class Main {
    public static void main(String[] args) {
        boolean gameover = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

        if(score < 5000 && score >1000){
            System.out.println("Your score was less than 5000 but greater than 1000");
        } else if (score <1000) {
            System.out.println("Your score less than 1k");

        } else{
            System.out.println("Got here");
        }
    }
}
