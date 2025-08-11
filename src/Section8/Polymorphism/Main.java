package Section8.Polymorphism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Movie theMovie = Movie.getMovie("Science","Star Wars");
//        theMovie.watchMovie();

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Type (A for Adventure, C for Comedy, " +
                    "S for Science Fiction, or Q to quit): ");
            String type = s.nextLine();
            
            if (type.toUpperCase().equals("Q")) {
                System.out.println("Goodbye!");
                break;
            }
            
            System.out.print("Enter movie title: ");
            String title = s.nextLine();
            
            Movie theMovie = Movie.getMovie(type, title);
            theMovie.watchMovie();
            System.out.println();
        }
        s.close();
    }
}
