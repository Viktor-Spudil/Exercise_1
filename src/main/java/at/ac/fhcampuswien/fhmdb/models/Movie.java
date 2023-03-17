package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;


public class Movie implements Comparable<Movie>{
    private String title;
    private String description;
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

        // Add genres to movies
        List<String> theDarkKnightGenre = new ArrayList<>();
        theDarkKnightGenre.add("Action");
        theDarkKnightGenre.add("Thriller");
        theDarkKnightGenre.add("Adventure");

        List<String> starWarsGenre = new ArrayList<>();
        starWarsGenre.add("Action");
        starWarsGenre.add("Adventure");
        starWarsGenre.add("Science Fiction");

        List<String> forrestGumpGenre = new ArrayList<>();
        forrestGumpGenre.add("Comedy");
        forrestGumpGenre.add("Drama");
        forrestGumpGenre.add("Romance");

        List<String> silenceOfTheLambsGenre = new ArrayList<>();
        silenceOfTheLambsGenre.add("Crime");
        silenceOfTheLambsGenre.add("Drama");
        silenceOfTheLambsGenre.add("Thriller");

        List<String> matrixGenre = new ArrayList<>();
        matrixGenre.add("Action");
        matrixGenre.add("Science Fiction");

        List<String> lionKingGenre = new ArrayList<>();
        lionKingGenre.add("Animation");
        lionKingGenre.add("Adventure");
        lionKingGenre.add("Drama");

        List<String> jawsGenre = new ArrayList<>();
        jawsGenre.add("Adventure");
        jawsGenre.add("Drama");
        jawsGenre.add("Thriller");

        List<String> theShiningGenre = new ArrayList<>();
        theShiningGenre.add("Drama");
        theShiningGenre.add("Horror");

        List<String> jurassicParkGenre = new ArrayList<>();
        jurassicParkGenre.add("Adventure");
        jurassicParkGenre.add("Thriller");

        List<String> groundhogDayGenre = new ArrayList<>();
        groundhogDayGenre.add("Comedy");
        groundhogDayGenre.add("Fantasy");
        groundhogDayGenre.add("Romance");

        // Generate movies
        Movie darkKnight = new Movie("The Dark Knight", "A vigilante fights crime and corruption in Gotham City.", theDarkKnightGenre);
        movies.add(darkKnight);

        Movie starWars = new Movie("Star Wars: Episode IV - A New Hope", "A farm boy joins a rebel alliance to save the galaxy from an evil empire.", starWarsGenre);
        movies.add(starWars);

        Movie forrestGump = new Movie("Forrest Gump", "A man with a low IQ accomplishes great things in his life.", forrestGumpGenre);
        movies.add(forrestGump);

        Movie silenceOfTheLambs = new Movie("The Silence of the Lambs", "An FBI trainee seeks the help of a psychopathic prisoner to catch a serial killer.", silenceOfTheLambsGenre);
        movies.add(silenceOfTheLambs);

        Movie matrix = new Movie("The Matrix", "A hacker discovers a shocking truth about the reality he lives in.", matrixGenre);
        movies.add(matrix);

        Movie lionKing = new Movie("The Lion King", "A young lion prince must overthrow his uncle to reclaim his rightful place as king.", lionKingGenre);
        movies.add(lionKing);

        Movie jaws = new Movie("Jaws", "A police chief, a marine biologist, and a fisherman hunt a great white shark.", jawsGenre);
        movies.add(jaws);

        Movie shining = new Movie("The Shining", "A family caretaker experiences supernatural occurrences at an isolated hotel.", theShiningGenre);
        movies.add(shining);

        Movie jurassicPark = new Movie("Jurassic Park", "A billionaire invites a team of scientists to his theme park filled with cloned dinosaurs.", jurassicParkGenre);
        movies.add(jurassicPark);

        Movie groundhogDay = new Movie("Groundhog Day", "A weatherman relives the same day over and over again.", groundhogDayGenre);
        movies.add(groundhogDay);

        return movies;
    }

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }

    public boolean containsString(String substring) {
        return String.format("%s %s", title, description).toLowerCase().contains(substring.toLowerCase());
    }
}
