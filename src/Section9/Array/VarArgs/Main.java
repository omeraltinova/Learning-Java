package Section9.Array.VarArgs;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello world again!");

        String[] splitStrings = "Hello World Again!".split(" ");
        printText(splitStrings);

        System.out.println("-".repeat(30));
        printText("Hello");

        System.out.println("-".repeat(30));
        printText("Hello","World","Again");

        System.out.println("-".repeat(30));
        printText();

        String[] sArray = {"first","second","third","fourth","fifth"};
        System.out.println(String.join(",",sArray));
    }
    private static void printText(String... textList){
        for(String t : textList){
            System.out.println(t);
        }
    }
}
