package Section8.Encapsulation;

public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        health-=damage;
        if(health<0){
            System.out.println("Player knocked out!");
        }
    }

    public int healthRemaining(){
        return health;
    }
    public void restoreHealth(int extrahealth){
        health+=extrahealth;
        if(health>100){
            health=100;
            System.out.println("Full Health!");
        }
    }
}
