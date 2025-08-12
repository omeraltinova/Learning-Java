package Section8.Polymorphism.Example;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Engine started");
    }
    protected void runEngine(){
        System.out.println("Run Engine");
    }
    public void drive(){
        System.out.println("I drive " + getClass().getSimpleName());
        runEngine();
    }
}
class GasPoweredCar extends Car{
    private double avgKmPerLiter;
    private int cylinders = 6;

    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPerLiter, int cylinders) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
    }

    @Override
    protected void runEngine() {

        System.out.printf("Gas -> usage exceeds the average %.2f %n",avgKmPerLiter);
    }

    @Override
    public void startEngine() {
        System.out.println("Gas -> cylinders are fired up!");
    }
}

class ElectricCar extends Car{
    private double avgKmPerCharge;
    private int batterySizew = 6;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int batterySizew) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySizew = batterySizew;
    }

    @Override
    protected void runEngine() {

        System.out.printf("BEV -> usage under the average: %.2f %n", avgKmPerCharge);
    }

    @Override
    public void startEngine() {

        System.out.printf("BEV -> switch %d kWh battery on, Ready!%n", batterySizew);
    }
}
class HybridCar extends Car{
    private double avgKmPerLiter;
    private int cylinders = 6;
    private int batterySize;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerLiter, int cylinders,int batterySize) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
        this.batterySize=batterySize;
    }

    @Override
    protected void runEngine() {
        System.out.printf("Hybrid -> switch %d kWh battery + %.2f km/L usage %n", batterySize, avgKmPerLiter);
    }

    @Override
    public void startEngine() {
        System.out.printf("Hybrid -> %d kWh battery + %d cylinders are starting up!%n", batterySize, cylinders);
    }
}
