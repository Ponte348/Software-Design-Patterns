import java.util.List;
public interface MovieBuilder {
    public void setMovieTitle(String title);
    public void setMovieYear(int year);
    public void setMovieDirector(Person director);
    public void setMovieWriter(Person writer);
    public void setMovieSeries(String series);
    public void setMovieCast(List<Person> cast);
    public void setMovieLocations(List<Place> locations);
    public void setMovieLanguages(List<String> languages);
    public void setMovieGenres(List<String> genres);
    public void setMovieType(String type);
    public void createMovie(String title, int year, Person director, Person writer, String series, List<Person> cast, List<Place> locations, List<String> languages, List<String> genres);
    Movie getMovie();
}
