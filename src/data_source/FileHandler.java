package data_source;
import domain_model.Movie;
import domain_model.MovieCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileHandler {

    private final File file = new File("moviecollection.csv");

    public MovieCollection loadMovies() {

         MovieCollection movies = new MovieCollection();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] movieData = line.split(",");
                    String title = movieData[0].trim();
                    String director = movieData[1].trim();
                    int year = Integer.parseInt(movieData[2].trim());
                    boolean color = Boolean.parseBoolean(movieData[3].trim());
                    int lengthInMinutes = Integer.parseInt(movieData[4].trim());
                    String genre = movieData[5].trim();

                    movies.addMovie(title, director, year, color, lengthInMinutes, genre);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file could not be found");
        }
        return movies;
    }


    public void saveListOfMovies(MovieCollection movies) {
        try {
            PrintStream output = new PrintStream("moviecollection.csv");
            for (Movie movie : movies.getMovieCollectionList()) {
                output.println(movie.toCsvString());
            }
            output.close();
        } catch (FileNotFoundException a) {
            System.out.println("The file could not be found");
        }
    }
}
