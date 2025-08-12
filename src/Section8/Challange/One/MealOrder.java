package Section8.Challange.One;

public class MealOrder {
    private Burger burger;
    private Item drink;
    private Item side;

    public MealOrder(String burger, String drink, String side) {
        this.burger = new Burger(burger,4.0);
        this.drink = new Item("DRINK",drink,1.00);
        this.side = new Item("SIDE",side,1.50);
    }
    public MealOrder(){
        this("regular","coke","fries");
    }

    public double getTotalPrice(){
        return side.getAdjustedPrice() + drink.getAdjustedPrice() + burger.getAdjustedPrice();
    }

    public void printItemizedList(){
        burger.printItem();
        drink.printItem();
        side.printItem();
        System.out.println("-".repeat(30));
        Item.printItem("TOTAL PRICE",getTotalPrice());
    }
    public void addBurgerToppings(String extra1,String extra2,String extra3){
        burger.addTopping(extra1,extra2,extra3);
    }
    public void setDrinkSize(String size){
        drink.setSize(size);
    }
}
