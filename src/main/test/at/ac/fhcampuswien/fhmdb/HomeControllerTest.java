package at.ac.fhcampuswien.fhmdb;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    public class HomeControllerTest {

        private HomeController controller;
        public List<Movie> allMovies = Movie.initializeMovies();


        @Start
        public void start(Stage stage) {
            controller = new HomeController();
        }

        @Before
        public void setUp() throws Exception {
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
        public void testSearchByTitle() {
            FxRobot robot = new FxRobot();
            robot.clickOn(controller.searchField).write("Avengers");
            robot.clickOn(controller.searchBtn);

            ObservableList<Movie> items = controller.movieListView.getItems();
            assertEquals(1, items.size());
            assertEquals("Avengers", items.get(0).getTitle());
        }


        @Test
        public void testSearchEmptyField() {
            FxRobot robot = new FxRobot();
            robot.clickOn(controller.searchBtn);

            ObservableList<Movie> items = controller.movieListView.getItems();
            assertEquals(4, items.size());
        }
}