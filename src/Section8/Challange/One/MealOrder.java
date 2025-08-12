package Section8.Challange.One;

public class MealOrder {
    private Burger burger;
    private Item drink;
    private Item side;

    public MealOrder(String burger, String drink, String side) {
        if(burger.equalsIgnoreCase("deluxe")){
            this.burger = new DeluxeBurger(burger,8.5);
        }else{
            this.burger = new Burger(burger,4.0);
        }
        this.drink = new Item("DRINK",drink,1.00);
        this.side = new Item("SIDE",side,1.50);
    }
    public MealOrder(){
        this("regular","coke","fries");
    }

    public double getTotalPrice(){
        if(burger instanceof DeluxeBurger){
            return burger.getAdjustedPrice();
        }

        return side.getAdjustedPrice() + drink.getAdjustedPrice() + burger.getAdjustedPrice();
    }

    public void printItemizedList(){
        burger.printItem();
        if(burger instanceof DeluxeBurger){
            Item.printItem(drink.getName(),0);
            Item.printItem(side.getName(),0);
        }else{
            drink.printItem();
            side.printItem();
        }
        System.out.println("-".repeat(30));
        Item.printItem("TOTAL PRICE",getTotalPrice());
    }
    public void addBurgerToppings(String extra1,String extra2,String extra3){
        burger.addTopping(extra1,extra2,extra3);
    }
    public void addBurgerToppings(String extra1,String extra2,String extra3,String extra4,String extra5){
        if(burger instanceof DeluxeBurger db){
            db.addTopping(extra1,extra2,extra3,extra4,extra5);
        }else{
            burger.addTopping(extra1,extra2,extra3);
        }

    }
    public void setDrinkSize(String size){
        drink.setSize(size);
    }
}
