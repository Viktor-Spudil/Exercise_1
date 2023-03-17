package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
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

        List<Movie> filteredMovies = controller.textFilter("movie", allMovies);

        for (Movie movie : filteredMovies) {
            assertTrue(movie.getTitle().toLowerCase().contains("movie")
                    || movie.getDescription().toLowerCase().contains("movie"));
        }
    }

    @Test
    void testSearchAll() {
        HomeController controller = new HomeController();

        controller.genreComboBox.setValue("All");
        controller.searchField.setText("");

        controller.searchBtn.fire();

        assertEquals(allMovies, controller.movieListView.getItems());
    }

    @Test
    void testSearchByGenre() {
        HomeController controller = new HomeController();

        String selectedGenre = "Action";
        List<Movie> expectedMovies = controller.genreFilter(selectedGenre, allMovies);

        controller.genreComboBox.setValue(selectedGenre);
        controller.searchField.setText("");

        controller.searchBtn.fire();

        assertEquals(expectedMovies, controller.movieListView.getItems());
    }

    @Test
    void testSearchByText() {
        HomeController controller = new HomeController();

        String searchText = "movie";
        List<Movie> expectedMovies = controller.textFilter(searchText, allMovies);

        controller.genreComboBox.setValue("All");
        controller.searchField.setText(searchText);

        controller.searchBtn.fire();

        assertEquals(expectedMovies, controller.movieListView.getItems());
    }

}


