package Section8.Encapsulation;

public class EnhancedPlayer {
    private String fullName;
    private int healthPercentage;
    private String weapon;

    public EnhancedPlayer(String fullName) {
        this(fullName,100,"Sword");
    }

    public EnhancedPlayer(String fullName, int health, String weapon) {
        this.fullName = fullName;
        if(health<=0){
            this.healthPercentage =1;
        }else if(health>100){
            this.healthPercentage=100;
        }else this.healthPercentage =health;
        this.weapon = weapon;
    }
    public void loseHealth(int damage){
        healthPercentage -=damage;
        if(healthPercentage <0){
            System.out.println("Player knocked out!");
        }
    }

    public int healthRemaining(){
        return healthPercentage;
    }
    public void restoreHealth(int extrahealth){
        healthPercentage +=extrahealth;
        if(healthPercentage >100){
            healthPercentage =100;
            System.out.println("Full Health!");
        }
    }


}