import java.util.List;
public class MovieMaster {
    private MovieBuilder movieBuilder;
    private Movie movie;

    MovieMaster(){
        movieBuilder = null;
        movie = null;
    }

    public void setMovieBuilder(MovieBuilder movieBuilder) {
        this.movieBuilder = movieBuilder;
    }

    public void createMovie(String title, int year, Person director, Person writer, String series, List<Person> cast, List<Place> locations, List<String> languages, List<String> genres) {
        movieBuilder.createMovie(title, year, director, writer, series, cast, locations, languages, genres);
        movie = movieBuilder.getMovie();
    }

    public Movie getMovie() {
        return movie;
    }
}
