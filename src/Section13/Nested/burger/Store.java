package Section13.Nested.burger;

public class Store {

    public static void main(String[] args) {
        Meal regularMeal = new Meal();

        regularMeal.addToppings("KETCHUP","MAYO","CHEDDAR");
        System.out.println(regularMeal);

        Meal USRegular = new Meal(0.68);
        System.out.println(USRegular);
    }
}
