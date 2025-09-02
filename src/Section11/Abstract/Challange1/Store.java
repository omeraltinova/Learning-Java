package Section11.Abstract.Challange1;

import java.util.ArrayList;


record orderItem(int qty,ProductForSale product){}

public class Store {


    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();



    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Oil Paint","description",1350));

        storeProducts.add(new ArtObject("Sculpture","description 2",2000));

        storeProducts.add(new Furniture("Desk","Description for desk",1500));

        storeProducts.add(new Furniture("Lamp","description for lamp",500));

        listProducts();


        System.out.println("\nOrder1");
        var order1= new ArrayList<orderItem>();
        addItemToOrder(order1,1,2);
        addItemToOrder(order1,0,1);
        printOrder(order1);

        System.out.println("\nOrder2");
        var order2= new ArrayList<orderItem>();
        addItemToOrder(order2,3,5);
        addItemToOrder(order2,0,1);
        addItemToOrder(order2,2,1);
        printOrder(order2);

    }



    public static void listProducts(){
        for(var item : storeProducts){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }
    public static void addItemToOrder(ArrayList<orderItem> order,int orderIndex,int qty){
        order.add(new orderItem(qty,storeProducts.get(orderIndex)));
    }
    public static void printOrder(ArrayList<orderItem> order){

        double salesTotal = 0;
        for(var item: order){
            item.product().printPricedItem(item.qty());
            salesTotal+= item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n",salesTotal);
    }
}
