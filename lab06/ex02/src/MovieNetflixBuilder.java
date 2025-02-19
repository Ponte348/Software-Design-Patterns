import java.util.List;
public class MovieNetflixBuilder implements MovieBuilder{
    private Movie movie;

    public MovieNetflixBuilder() {
    }

    public void setMovieTitle(String title) {
        movie.setTitle(title);
    }
    public void setMovieYear(int year) {
        movie.setYear(year);
    }
    public void setMovieDirector(Person director) {
        movie.setDirector(director);
    }
    public void setMovieWriter(Person writer) {
        movie.setWriter(writer);
    }
    public void setMovieSeries(String series) {
        movie.setSeries(series);
    }
    public void setMovieCast(List<Person> cast) {
        movie.setCast(cast);
    }
    public void setMovieLocations(List<Place> locations) {
        movie.setLocations(locations);
    }
    public void setMovieLanguages(List<String> languages) {
        movie.setLanguages(languages);
    }
    public void setMovieGenres(List<String> genres) {
        movie.setGenres(genres);
    }
    public void setMovieType(String type) {
        movie.setType(type);
    }
    public void createMovie(String title, int year, Person director, Person writer, String series, List<Person> cast, List<Place> locations, List<String> languages, List<String> genres) {
        movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setDirector(director);
        movie.setWriter(writer);
        movie.setSeries(series);
        movie.setCast(cast);
        movie.setLocations(locations);
        movie.setLanguages(languages);
        movie.setGenres(genres);
        movie.setType("Netflix");
    }

    @Override
    public Movie getMovie() {
        return movie;
    }
}
