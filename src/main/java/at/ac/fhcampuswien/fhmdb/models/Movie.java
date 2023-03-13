package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private List<String> genres = new ArrayList<>();

    public Movie(String title, String description, List<String> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        List<String> genres1 = new ArrayList<>();
        genres1.add("Action");
        genres1.add("Thriller");
        genres1.add("Adventure");

        Movie movie1 = new Movie("A: The Dark Knight", "A: description", genres1);
        movies.add(movie1);

        List<String> genres2 = new ArrayList<>();
        genres2.add("Comedy");
        genres2.add("Romance");

        Movie movie2 = new Movie("B: Avengers", "B: description", genres2);
        movies.add(movie2);

        List<String> genres3 = new ArrayList<>();
        genres3.add("Drama");
        genres3.add("Mystery");

        Movie movie3 = new Movie("C: The Shawshank Redemption", "C: description", genres3);
        movies.add(movie3);

        List<String> genres4 = new ArrayList<>();
        genres4.add("Horror");
        genres4.add("Mystery");
        genres4.add("Thriller");

        Movie movie4 = new Movie("D: Russia mother", "D: description", genres4);
        movies.add(movie4);

        return movies;
    }
}
