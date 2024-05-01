package Section5.CodeBlocksAndMethods;

public class MainChallenge {
    public static void main(String[] args) {
        boolean gameover = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calcuateScore(gameover,score,levelCompleted,bonus);
        System.out.println("The highScore is " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        System.out.println("The next highScore is: "+ calcuateScore(gameover,score,levelCompleted,bonus));
    }

    public static int calcuateScore(boolean gameover,int score, int levelCompleted, int bonus ){

        int finalscore = score;

        if (gameover) {
            finalscore += (levelCompleted * bonus);
            finalscore += 1000;
        }

        return(finalscore);
    }
}
