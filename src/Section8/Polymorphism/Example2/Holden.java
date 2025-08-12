package Section8.Polymorphism.Example2;

public class Holden extends Car {

    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + "startengine";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + "brake";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + "accelerate";
    }
}
