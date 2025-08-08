package Section8.ComputerProject;

public class Main {
    public static void main(String[] args) {
        ComputerCase theCase = new ComputerCase("220B", "Dell", "240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, "2540x1440");
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");
        PersonalComputer thePC = new PersonalComputer("220B", "Dell", theCase, theMonitor, theMotherboard);

//        thePC.getMonitor().drawPixelAt(10,10,"red");
//        thePC.getMotherboard().loadProgram("Warp");
//        thePC.getTheCase().pressPowerButton();

        thePC.powerUp();

    }
}
