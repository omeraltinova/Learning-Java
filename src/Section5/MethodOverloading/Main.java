package Section5.MethodOverloading;

public class Main {
    public static void main(String[] args) {

        System.out.println("New score is : "+ calculateScore("Faruk",500));
        System.out.println("New score is : "+ calculateScore(10));

    }

    public static int calculateScore(String playerName,int score){
        System.out.println("Player " + playerName + " scored " + score);
        return(score * 1000);
    }
    public static int calculateScore(int score){
        return(calculateScore("Anonymous",score));
    }
    public static int calculateScore(){
        System.out.println("No name or score included");
        return(0);
    }
}
