package Section11.Abstract.Challange1;

public class Furniture extends ProductForSale{

    public Furniture(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + type + "was manufactured in Turkey ");

        System.out.printf("The price of the piece is $%6.2f ",price);
        System.out.println(description);
    }
}
