import java.util.List;

public class Movie {
   private String title;
   private int year;
   private Person director;
   private Person writer;
   private String series;
   private List<Person> cast;
   private List<Place> locations;
   private List<String> languages;
   private List<String> genres;
   private String type;
   
   public Movie(
      final String movieTitle,
      final int movieYear,
      final Person movieDirector,
      final Person movieWriter,
      final String movieSeries,
      final List<Person> movieCast,
      final List<Place> movieLocations,
      final List<String> movieLanguages,
      final List<String> movieGenres,
      final String movieType)    {
      this.title = movieTitle;
      this.year = movieYear;
      this.director = movieDirector;
      this.writer = movieWriter;
      this.series = movieSeries;
      this.cast = movieCast;
      this.locations = movieLocations;
      this.languages = movieLanguages;
      this.genres = movieGenres;
      this.type = movieType;
   }

   public Movie() {
   }

   @Override
   public String toString() {
      return "Type: " + type + "\n" +
             "Title: " + title + "\n" +
             "Year: " + year + "\n" +
             "Director: " + director + "\n" +
             "Writer: " + writer + "\n" +
             "Series: " + series + "\n" +
             "Cast: " + cast + "\n" +
             "Locations: " + locations + "\n" +
             "Languages: " + languages + "\n" +
             "Genres: " + genres + "\n";
   }

   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }

   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
   }

   public Person getDirector() {
      return director;
   }
   public void setDirector(Person director) {
      this.director = director;
   }

   public Person getWriter() {
      return writer;
   }
   public void setWriter(Person writer) {
      this.writer = writer;
   }

   public String getSeries() {
      return series;
   }
   public void setSeries(String series) {
      this.series = series;
   }

   public List<Person> getCast() {
      return cast;
   }
   public void setCast(List<Person> cast) {
      this.cast = cast;
   }

   public List<Place> getLocations() {
      return locations;
   }
   public void setLocations(List<Place> locations) {
      this.locations = locations;
   }

   public List<String> getLanguages() {
      return languages;
   }
   public void setLanguages(List<String> languages) {
      this.languages = languages;
   }

   public List<String> getGenres() {
      return genres;
   }
   public void setGenres(List<String> genres) {
      this.genres = genres;
   }

   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }
}
