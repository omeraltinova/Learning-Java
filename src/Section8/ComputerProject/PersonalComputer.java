package Section8.ComputerProject;

public class PersonalComputer extends Product{
    private ComputerCase theCase;
    private Monitor monitor;
    private Motherboard motherboard;
    public PersonalComputer(String model, String manufacturer, ComputerCase theCase, Monitor monitor, Motherboard motherboard) {
        super(model, manufacturer);
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }
    private void drawLogo(){
        monitor.drawPixelAt(1200,50,"yellow");
    }
    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

//    public ComputerCase getTheCase() {
//        return theCase;
//    }
//
//    public Monitor getMonitor() {
//        return monitor;
//    }
//
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
}
