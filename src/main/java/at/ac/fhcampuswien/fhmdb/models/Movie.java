package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Comparable<Movie> {
    // === 0. NOTES ===
    // === 1. CLASS VARIABLES ===
    // === 2. OBJECT VARIABLES ===
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres;


    // === 3. CONSTRUCTORS ===
    // --- 3.1 STATIC BLOCKS ---
    // --- 3.2 INSTANCE INITIALIZER ---
    // --- 3.3 REAL CONSTRUCTORS ---
    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }//end public Movie(String title, String description, List<Genre> genres)


    // === 4. STATIC METHODS ===
    // === 5. GETTER AND SETTER ===
    public String getTitle() {
        return this.title;
    }//end public String getTitle()

    public String getDescription() {
        return this.description;
    }//end public String getDescription()

    public List<Genre> getGenres() {
        return this.genres;
    }//end public List<Genre> getGenres()


    // === 6. MISCELLANEOUS OBJECT METHODS ===
    public static List<Movie> initializeMovies() {
        List<Movie> movies = new ArrayList<>();


        // TODO add some dummy data here
        List<Genre> genres1 = new ArrayList<>();
        genres1.add(Genre.HISTORY);
        genres1.add(Genre.BIOGRAPHY);
        movies.add(new Movie("FilmA", "Description filmA", genres1));

        List<Genre> genres2 = new ArrayList<>();
        genres2.add(Genre.WAR);
        genres2.add(Genre.ACTION);
        movies.add(new Movie("FilmB", "Description filmB", genres2));

        List<Genre> genres3 = new ArrayList<>();
        genres3.add(Genre.ROMANCE);
        genres3.add(Genre.COMEDY);
        movies.add(new Movie("FilmC", "Description filmC", genres3));

        List<Genre> genres4 = new ArrayList<>();
        genres4.add(Genre.DOCUMENTARY);
        genres4.add(Genre.FAMILY);
        movies.add(new Movie("FilmD", "Description filmD", genres4));

        return movies;
    }//end public static List<Movie> initializeMovies()

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }//end public int compareTo(Movie movie)

    public boolean containsString(String substring) {
        return String.format("%s %s", title, description).toLowerCase().contains(substring.toLowerCase());
    }//end public boolean containsSubstring(String substring)


    // === 7. MAIN ===
}//end public class Movie implements Comparable<Movie>
