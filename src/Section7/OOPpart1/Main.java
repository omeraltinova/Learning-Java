package Section7.OOPpart1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
       car.setMake("Porsche");
       car.setColor("Black");
       car.setModel("Carrera");
       car.setConvertible(true);
       car.setDoors(2);
       System.out.println("make " + car.getMake());
       System.out.println("model = " + car.getModel());
        car.describeCar();

        Car targa = new Car();
        targa.setMake("Porsche");
        targa.setColor("red");
        targa.setModel("targa");
        targa.setConvertible(false);
        targa.setDoors(2);
        targa.describeCar();
    }
}
