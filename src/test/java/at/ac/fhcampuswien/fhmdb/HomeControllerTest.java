package at.ac.fhcampuswien.fhmdb;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    private HomeController controller;
    public List<Movie> allMovies = Movie.initializeMovies();


    @Start
    void start(Stage stage) {
        controller = new HomeController();
    }

    @Before
    void setUp() throws Exception {
        // initialize UI components
        controller.genreComboBox = new ComboBox<>();
        controller.movieListView = new ListView<>();
        controller.searchBtn = new Button();
        controller.searchField = new TextField();
        controller.sortBtn = new Button();

        controller.allMovies = Movie.initializeMovies();

        // initialize the controller
        controller.initialize(null, null);
    }

    @Test
    void testSearchByTitle() {
        FxRobot robot = new FxRobot();
        robot.clickOn(controller.searchField).write("Avengers");
        robot.clickOn(controller.searchBtn);

        ObservableList<Movie> items = controller.movieListView.getItems();
        assertEquals(1, items.size());
        assertEquals("B: Avengers", items.get(0).getTitle());
    }


    @Test
    void testSearchEmptyField() {
        FxRobot robot = new FxRobot();
        robot.clickOn(controller.searchBtn);

        ObservableList<Movie> items = controller.movieListView.getItems();
        assertEquals(4, items.size());
    }

    @Test
    void testFilterByGenre() {
        FxRobot robot = new FxRobot();
        robot.clickOn(controller.genreComboBox).clickOn("Action");
        robot.clickOn(controller.searchBtn);

        ObservableList<Movie> items = controller.movieListView.getItems();
        assertEquals(2, items.size());
        assertEquals("A: Avengers", items.get(0).getTitle());
        assertEquals("B: Avengers", items.get(1).getTitle());
    }


}
