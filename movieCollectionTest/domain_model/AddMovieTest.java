package domain_model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
class AddMovieTest {

    @Test
    void addMovie() {
        //Arrange - setup our test objects.
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Rose", "James", 2002, true, 120, "future");

        //Act - Execute the method under test with the arranged conditions.
        int expectedMovie = 1;
        int actualMovie = movieCollection.getMovieCollectionList().size();


        //Assert -verify the actions's outcome is as expected
        Assertions.assertEquals(expectedMovie, actualMovie);
    }

    @Test
    void getMovieCollectionList() {
        //Arrange - setup our test objects.
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Silver", "James", 2002, true, 120, "future");

        //Act - Execute the method under test with the arranged conditions.
        ArrayList<Movie> expectedMovies = new ArrayList<Movie>();
        expectedMovies.add(new Movie("Silver", "James", 2002, true, 120, "future"));
        ArrayList<Movie> actualMovies = movieCollection.getMovieCollectionList();

        //Assert -verify the actions's outcome is as expected
        Assertions.assertArrayEquals(expectedMovies.toArray(), actualMovies.toArray());
    }
}