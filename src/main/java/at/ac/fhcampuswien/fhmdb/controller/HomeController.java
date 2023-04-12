package at.ac.fhcampuswien.fhmdb.controller;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.view.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

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
        genreComboBox.setPromptText("Filter by Genre");  // Select first item by default
        genreComboBox.getItems().add("All");
        genreComboBox.getItems().addAll(Genre.values());


        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {
                Collections.sort(observableMovies);
                sortBtn.setText("Sort (desc)");
            } else {
                Collections.reverse(observableMovies);
                sortBtn.setText("Sort (asc)");
            }
        });//end sortBtn.setOnAction(actionEvent ->

        // Search button:
        searchBtn.setOnAction(actionEvent -> {
            String query = searchField.getText();
            List<Movie> filteredMovies = new LinkedList<>();

            if (query.isBlank() && (genreComboBox.getValue().toString() == "All")) {
                observableMovies.clear();
                observableMovies.addAll(allMovies);
            }
            else {
                filteredMovies = filterByQuery(allMovies, query);
            }

        });//end sortBtn.setOnAction(actionEvent ->
    }//end public void initialize(URL url, ResourceBundle resourceBundle)

    public List<Movie> filterByQuery(List<Movie> moviesToFilter, String query) {
        List<Movie> filteredMovieList = new LinkedList<>();

        for (Movie movie : moviesToFilter) {
            if (movie.containsString(query)) {
                filteredMovieList.add(movie);
            }
        }

        return filteredMovieList;
    }//end public List<Movie> filterByQuery(List<Movie> moviesToFilter, String query)

    public List<Movie> filterByGenre(List<Movie> moviesToFilter, Genre genre) {
        List<Movie> filteredMovieList = new LinkedList<>();

        for (Movie movie: moviesToFilter) {
            if (movie.getGenres().contains(genre)) {
                filteredMovieList.add(movie);
            }
        }

        return filteredMovieList;
    }//end public List<Movie> filterByGenre(List<Movie> moviesToFilter, Genre genre)
}//end public class HomeController implements Initializable
