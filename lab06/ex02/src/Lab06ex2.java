import java.util.List;

public class Lab06ex2 {
    public static void main(String[] args) {

        MovieMaster movieMaster = new MovieMaster();
        movieMaster.setMovieBuilder(new MovieTelevisionBuilder());
        movieMaster.createMovie("The Office", 2005, new Person("Greg Daniels", "Director"), new Person("Ricky Gervais", "Writer"), "The Office", List.of(new Person("Steve Carell", "Michael Scott"), new Person("Rainn Wilson", "Dwight Schrute"), new Person("John Krasinski", "Jim Halpert")), List.of(new Place("Scranton, Pennsylvania")), List.of("English"), List.of("Comedy"));
        System.out.println(movieMaster.getMovie());

        movieMaster.setMovieBuilder(new MovieNetflixBuilder());
        movieMaster.createMovie("All quiet on the western front", 2022, new Person("Edward Berger", "Director"), new Person("Lesley Paterson", "Writer"), "All quiet on the western front", List.of(new Person("Felix Kammerer", "Paul Baumer"), new Person("Albert Schuch", "Stanislaus Katczinksy")), List.of(new Place("Germany")), List.of("German"), List.of("Drama"));
        System.out.println(movieMaster.getMovie());

        movieMaster.setMovieBuilder(new MovieIndependentBuilder());
        movieMaster.createMovie("Everything everywhere all at once", 2022, new Person("Daniel Kwan", "Director"), new Person("Daniel Scheinert", "Writer"),  "Everything everywhere all at once", List.of(new Person("Michelle Yeoh", "Evelyn Wang"), new Person("Stephanie Hsu", "Joy Wang"), new Person("Jamie Lee Curtis", "Deirdre Beaubeirdre")), List.of(new Place("United States")), List.of("English"), List.of("Action"));
        System.out.println(movieMaster.getMovie());

    }
}
