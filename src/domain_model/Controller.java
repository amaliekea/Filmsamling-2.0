package domain_model;

import data_source.FileHandler;

import java.util.Comparator;

public class Controller {
    private MovieCollection liste;
    private FileHandler filehandler;

    public Controller() {
        this.filehandler = new FileHandler();
        this.liste = filehandler.loadMovies();
    }


    public String addMovie(String title, String director, int year, boolean color, int minute, String genre) {
        return liste.addMovie(title, director, year, color, minute, genre);
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

    public void searchMovie(String title) {
        liste.searchMovie(title);
    }


    public void editMovie(String title) {
        liste.editMovie(title);
    }



    public String removeMovie(String title) {
        String r = liste.removeMovie(title);
        this.saveMovies();
        return r;
    }
}