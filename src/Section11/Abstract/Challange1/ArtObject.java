package Section11.Abstract.Challange1;

public class ArtObject extends ProductForSale{

    public ArtObject(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + type + "is a beautiful reproduction");

        System.out.printf("The price of the piece is $%6.2f ",price);
        System.out.println(description);
    }
}
