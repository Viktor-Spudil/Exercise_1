package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXComboBox;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    void testSearchAll() {
        HomeController controller = new HomeController();
        controller.genreComboBox = new JFXComboBox();
        controller.genreComboBox.setValue("All");
        controller.searchField.setText("");
        List<Movie> filteredMovies = controller.textFilter("", allMovies);

        assertEquals(allMovies, filteredMovies);
    }

    void testFilterAll() {
        HomeController controller = new HomeController();
        controller.genreComboBox = new JFXComboBox();
        controller.genreComboBox.setValue("All");
        controller.searchField.setText("");
        List<Movie> filteredMovies = controller.textFilter("", allMovies);

        assertEquals(allMovies, filteredMovies);
    }



}


