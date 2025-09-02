package Section11.Abstract.Challange1;

public abstract class ProductForSale {

    protected String type,description;
    protected double price;

    public ProductForSale(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public double getSalesPrice(int qty){
        return qty*price;
    }
    public void printPricedItem(int qty){
        System.out.printf("%2d qty at $%8.2f each %-15s %-35s %n",qty,price,type,description );
    }
    public abstract void showDetails();
}
