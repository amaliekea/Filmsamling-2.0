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
        movieCollection.searchMovie("Kill Bill");

        int expectedSize = 1;
        int actualMovie = movieCollection.getMovieCollectionList().size();
        Assertions.assertEquals(expectedSize, actualMovie);





    }

    @Test
    void editMovie() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Kill Bill", "Zuhur", 2001, true, 120, "Action");
        movieCollection.addMovie("Bandit", "WHO", 2022, true, 210, "Comedy");

        //act




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