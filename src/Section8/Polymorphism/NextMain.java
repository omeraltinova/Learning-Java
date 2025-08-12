package Section8.Polymorphism;

public class NextMain {
    public static void main(String[] args) {
//        Movie theMovie = Movie.getMovie("A", "Jaws");
//        theMovie.watchMovie();
//
//        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
//        jaws.watchMovie();
//
//        Object comedy = Movie.getMovie("C", "Airplane");
//        Comedy comedyMovie = (Comedy) comedy;
//        comedyMovie.watchComedy();
//
//        var airplane = Movie.getMovie("C", "Airplane");
//        airplane.watchMovie();

        Object unknownObject = Movie.getMovie("S", "Star Wars");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if(unknownObject instanceof Adventure){
            ((Adventure) unknownObject).watchAdventure();
        } else if(unknownObject instanceof ScienceFiction syfy){
            syfy.watchScienceFiction();
        }
    }
}
