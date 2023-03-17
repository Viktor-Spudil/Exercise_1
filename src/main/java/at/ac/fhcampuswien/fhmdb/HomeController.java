package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genres;
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
import java.util.ArrayList;
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

    public List<String> allGenres = Genres.getValues();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.getItems().add("All");
        genreComboBox.getItems().addAll(allGenres);
        genreComboBox.setPromptText("Filter by Genre");  // Select first item by default

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here
        searchBtn.setOnAction(actionEvent -> {

            observableMovies.clear();
            List<Movie> movieList = null;

            //Search field is empty and All is selected
            if (genreComboBox.getValue().toString().equals("All") && searchField.getText().isEmpty()) {
                // Show all movies
                observableMovies.clear();
                movieList = allMovies;

                //Search field is empty and a genre is selected
            } else if (!genreComboBox.getValue().toString().equals("All") && searchField.getText().isEmpty()) {
                observableMovies.clear();
                movieList = genreFilter(genreComboBox.getValue().toString(), allMovies);

                //Search field is not empty and All is selected
            } else if (genreComboBox.getValue().toString().equals("All") && !searchField.getText().isEmpty()) {
                observableMovies.clear();
                movieList = textFilter(searchField.getText(), allMovies);

                //Search field is not empty and genre is selected
            } else if (!genreComboBox.getValue().toString().equals("All") && !searchField.getText().isEmpty()) {
                observableMovies.clear();
                movieList = genreFilter(genreComboBox.getValue().toString(), allMovies);
                movieList = textFilter(searchField.getText(), movieList);
            }

            observableMovies.addAll(movieList);

        });

        // Sort button
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {
                observableMovies.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
                sortBtn.setText("Sort (desc)");
            } else {
                observableMovies.sort((o1, o2) -> o2.getTitle().compareTo(o1.getTitle()));
                sortBtn.setText("Sort (asc)");
            }
        });

    }

    public List<Movie> genreFilter(String genre, List<Movie> movies) {
        List<Movie> movieList = new ArrayList<>();

        for (Movie movie : movies) {
            if(movie.getGenres().contains(genre)) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    public List<Movie> textFilter(String someText, List<Movie> movies) {
        List<Movie> movieList = new ArrayList<>();
        someText = someText.toLowerCase();

        for(Movie movie : movies) {
            if(movie.getTitle().toLowerCase().contains(someText)){
                movieList.add(movie);
            } else if (movie.getDescription().toLowerCase().contains(someText)) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

}
