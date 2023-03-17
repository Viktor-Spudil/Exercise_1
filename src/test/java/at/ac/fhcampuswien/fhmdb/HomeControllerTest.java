package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXComboBox;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class HomeControllerTest {
    public List<Movie> allMovies = Movie.initializeMovies();

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

        List<Movie> filteredMovies = controller.textFilter("The Dark Knight", allMovies);

        for (Movie movie : filteredMovies) {
            assertEquals("The Dark Knight", movie.getTitle());
        }
    }

    @Test
    void testTextAndGenreFilter() {
        HomeController controller = new HomeController();
        List<Movie> movies = Movie.initializeMovies();
        List<Movie> filteredMovies = new ArrayList<>();
        List<Movie> filteredMovies2 = new ArrayList<>();

        filteredMovies.addAll(controller.textFilter("man",movies));
        filteredMovies2.addAll(controller.genreFilter("Adventure",filteredMovies));

        assertEquals(1, filteredMovies2.size());
    }

    @Test
    void testSearchAll() {
        HomeController controller = new HomeController();
        controller.genreComboBox = new JFXComboBox();
        controller.genreComboBox.setValue("All");
        controller.searchField.setText("");
        List<Movie> filteredMovies = controller.textFilter("", allMovies);

        assertEquals(allMovies, filteredMovies);
    }

    @Test
    void testFilterAll() {
        HomeController controller = new HomeController();
        controller.genreComboBox = new JFXComboBox();
        controller.genreComboBox.setValue("All");
        controller.searchField.setText("");
        List<Movie> filteredMovies = controller.textFilter("", allMovies);

        assertEquals(allMovies, filteredMovies);
    }



}


