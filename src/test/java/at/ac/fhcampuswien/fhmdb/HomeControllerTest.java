package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genres;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    private HomeController homeController;

    public List<Movie> allMovies = Movie.initializeMovies();

    void setUp(){
        homeController = new HomeController();
    }

    @Test
    void testGenreFilter() {
        HomeController controller = new HomeController();

        List<Movie> filteredMovies = controller.genreFilter("Action", allMovies);

        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains("Action"));
        }
    }
    @Test
    void testTextFilter() {
        HomeController controller = new HomeController();

        List<Movie> filteredMovies = controller.textFilter("movie", allMovies);

        for (Movie movie : filteredMovies) {
            assertTrue(movie.getTitle().toLowerCase().contains("movie")
                    || movie.getDescription().toLowerCase().contains("movie"));
        }
    }

}