package Section8.Encapsulation.Example;

public class Main {
    public static void main(String[] args) {
        // Create a printer with 50% toner, not duplex
        Printer printer = new Printer(50, false);

        // Print initial total pages printed
        System.out.println("initial page count = " + printer.getPagesPrinted());

        // First job
        int pagesPrinted = printer.printPages(5);
        System.out.printf("Current Job Pages: %d, Printer Total: %d %n",
                pagesPrinted, printer.getPagesPrinted());

        // Second job
        pagesPrinted = printer.printPages(10);
        System.out.printf("Current Job Pages: %d, Printer Total: %d %n",
                pagesPrinted, printer.getPagesPrinted());
    }
}
