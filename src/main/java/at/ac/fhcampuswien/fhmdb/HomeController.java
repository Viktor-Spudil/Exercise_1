package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.getItems().addAll("All", "Action", "Comedy", "Drama", "Horror", "Mystery", "Romance", "Thriller");
        genreComboBox.getSelectionModel().selectFirst();  // Select first item by default

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here
        genreComboBox.setOnAction(actionEvent -> {
            String selectedGenre = genreComboBox.getSelectionModel().getSelectedItem().toString();
            if (selectedGenre.equals("All")) {
                // Show all movies
                observableMovies.clear();
                observableMovies.addAll(allMovies);
            } else {
                // Filter movies by genre
                ObservableList<Movie> filteredMovies = FXCollections.observableArrayList();
                for (Movie movie : allMovies) {
                    if (movie.getGenres().contains(selectedGenre)) {
                        filteredMovies.add(movie);
                    }
                }
                observableMovies.clear();
                observableMovies.addAll(filteredMovies);
            }
        });

        // Add event handler to search button
        searchBtn.setOnAction(actionEvent -> {
            String searchText = searchField.getText().toLowerCase().trim();
            if (searchText.isEmpty()) {
                // field is empty = all movies
                observableMovies.clear();
                observableMovies.addAll(allMovies);
            } else {
                //filter movies by title,description
                ObservableList<Movie> filteredMovies = FXCollections.observableArrayList();
                for (Movie movie : allMovies) {
                    if (movie.getTitle().toLowerCase().contains(searchText) || movie.getDescription().toLowerCase().contains(searchText)) {
                        filteredMovies.add(movie);
                    }
                }
                observableMovies.clear();
                observableMovies.addAll(filteredMovies);
            }
        });

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                observableMovies.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
                sortBtn.setText("Sort (desc)");
            } else {
                // TODO sort observableMovies descending
                observableMovies.sort((o1, o2) -> o2.getTitle().compareTo(o1.getTitle()));
                sortBtn.setText("Sort (asc)");
            }
        });


    }
}