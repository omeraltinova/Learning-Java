package Section11.Interfaces;

enum FlightStages implements Trackable {GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;

    @Override
    public void track() {
        if(this!=GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }
}

record DragonFly(String name,String type) implements FlightEnabled{

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satellite implements OrbitEarth{


    public void achieveOrbit(){
        System.out.println("Orbit achieved!");
    }

    @Override
    public void argieveOrbit() {

    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

interface OrbitEarth extends FlightEnabled{

    void argieveOrbit();
}

interface FlightEnabled{

    double MILES_TO_KILOMETERS = 1.60934;
    double KILOMETERS_TO_MILES = 0.621371;
    public abstract void takeOff();
    abstract void land();
    void fly();
}

interface Trackable{

    void track();
}


public abstract class Animal {

    public abstract void move();
}
