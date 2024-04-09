package domain_model;
import data_source.FileHandler;

import java.util.Collections;
import java.util.Comparator;

public class Controller {
    private MovieCollection liste;
    private FileHandler filehandler;

    public Controller() {
        this.filehandler = new FileHandler();
        this.liste = filehandler.loadMovies();
    }


    public void addMovie(String title, String director, int year, boolean color, int minute, String genre) {
        liste.addMovie(title, director, year, color, minute, genre);
        System.out.println("Movie added successfully!");
        this.saveMovies();
    }

    public void printCollection(Comparator<Movie> movieCompare) {
        liste.sortMoviesBy(movieCompare);
        liste.printMyCollection();
    }

    public void loadMovies() {
        liste = filehandler.loadMovies();
    }

    public void saveMovies() {
        filehandler.saveListOfMovies(liste);
    }

    public void printMovie(int i) {
        liste.printMovie(i);
    }

    public int searchMovie(String title) {
        return liste.searchMovie(title);
    }

    public Movie getMovie(int movieNumber) {
        return liste.getMovie(movieNumber);
    }

    public void editMovie(int i, String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {
        liste.editMovie(i, title, director, year, Color, lengthInMinutes, genre);
        this.saveMovies();
    }


    public String removeMovie(String title) {
        String r = liste.removeMovie(title);
        this.saveMovies();
        return r;
    }
}