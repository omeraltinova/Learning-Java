package Section8.Polymorphism.Example;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car("GTR");
//        RunRace(car);
//
//        Car Ferrari = new ElectricCar("BLUE",15.4,6);
//        RunRace(Ferrari);

        Car Tesla = new ElectricCar("Tesla Model Y",568,75);
        RunRace(Tesla);

        Car ferrariHybrid = new HybridCar("Black Ferrari",16,8,8);
        RunRace(ferrariHybrid);
    }

    public static void RunRace(Car car){
        car.startEngine();
        car.drive();
    }
}
