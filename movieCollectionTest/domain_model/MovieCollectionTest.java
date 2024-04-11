package domain_model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void searchMovie() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Kill Bill", "Zuhur", 2001, true, 120, "Action");

        //Act

        int expectedSize = 1;
        int actualMovie = movieCollection.getMovieCollectionList().size();





    }

    @Test
    void editMovie() {
    }

    @Test
    void removeMovie() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Kill bill", "Zuhur", 2001, true, 120, "Action");
        movieCollection.addMovie("Amalie", "Amalie", 2002, false, 173, "Horror");

        //act
        movieCollection.removeMovie("Kill bill");

        //assert

        int exceptedSize = 1;
        int actualMovie = movieCollection.getMovieCollectionList().size();

        Assertions.assertEquals(exceptedSize, actualMovie);

    }
}