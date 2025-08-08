package Section8.Example1;

public class Bedroom {
    private String name;
    private Wall wall1,wall2,wall3,wall4;
    private Bed bed;
    private Ceiling ceiling;
    private Lamp lamp;

    public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4,Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.bed = bed;
        this.lamp = lamp;
        this.ceiling=ceiling;
    }
    public Lamp getLamp(){
        return lamp;
    }
    public void makeBed(){
        // Print in the exact format expected by tests
        System.out.print("Bedroom -> Making bed | ");
        bed.make();
    }
}
