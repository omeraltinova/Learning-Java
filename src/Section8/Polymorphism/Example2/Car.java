package Section8.Polymorphism.Example2;

public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders,String name){
        this.cylinders=cylinders;
        this.name=name;
    }


    public String startEngine(){
        return "Engine is starting";
    }
    public String accelerate(){
        return "Car is accelerating";
    }
    public String brake(){
        return "Braking!";
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }
}
