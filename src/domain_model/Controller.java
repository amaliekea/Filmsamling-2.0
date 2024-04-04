package domain_model;

import domain_model.Movie;

public class Controller {
    private MovieCollection liste;

    public Controller() {
        liste = new MovieCollection();
    }

    public void addMovie(String title, String director, int year, boolean color, int minute, String genre) {
        liste.addMovie(title, director, year, color, minute, genre);
        System.out.println("domain_model.Movie added successfully!");
    }
    public void printCollection() {
        liste.printMyCollection();
    }
    public void printMovie (int i) {
        liste.printMovie(i);
    }
    public int searchMovie(String title) {
        return liste.searchMovie(title);
    }
    public Movie getMovie(int movieNumber) {
        return liste.getMovie(movieNumber);
    }
    public void editMovie (int i, String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {
        liste.editMovie(i, title, director, year, Color, lengthInMinutes, genre);
    }
    public String removeMovie(String title) {
        return liste.removeMovie(title);
    }
}