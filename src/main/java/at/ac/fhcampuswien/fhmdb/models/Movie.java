package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private List<String> genres = Genres.getValues();

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


        List<String> theDarkKnightGenre = new ArrayList<>();
        theDarkKnightGenre.add("Action");
        theDarkKnightGenre.add("Thriller");
        theDarkKnightGenre.add("Adventure");

        List<String> avengersGenre = new ArrayList<>();
        avengersGenre.add("Comedy");
        avengersGenre.add("Romance");
        avengersGenre.add("Drama");

        List<String> theShawshankRedemptionGenre = new ArrayList<>();
        theShawshankRedemptionGenre.add("Drama");
        theShawshankRedemptionGenre.add("Mystery");
        theShawshankRedemptionGenre.add("Thriller");

        List<String> russiaMotherGenre = new ArrayList<>();
        russiaMotherGenre.add("Horror");
        russiaMotherGenre.add("Mystery");
        russiaMotherGenre.add("Thriller");


        Movie movie1 = new Movie("A: The Dark Knight", "This is a movie", theDarkKnightGenre);
        movies.add(movie1);


        Movie movie2 = new Movie("B: Avengers", "B: description", avengersGenre);
        movies.add(movie2);


        Movie movie3 = new Movie("C: The Shawshank Redemption", "C: description", theShawshankRedemptionGenre);
        movies.add(movie3);


        Movie movie4 = new Movie("D: Russia mother", "D: description", russiaMotherGenre);
        movies.add(movie4);

        return movies;
    }
}
