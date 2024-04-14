package domain_model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MovieCollection {
    protected ArrayList<Movie> filmObjekter;
    Scanner scanner = new Scanner(System.in);


    public MovieCollection() {
        filmObjekter = new ArrayList<>();
    }

    public void sortMoviesBy(Comparator<Movie> movieCompare) {
        filmObjekter.sort(movieCompare);
    }

    public void editMovie(String title) {
        boolean continueEditing = true;

        while (continueEditing) {
            boolean hasFound = false;

            for (Movie m : filmObjekter) {
                if (m.getTitle().equalsIgnoreCase(title)) {
                    System.out.println("Enter new movie details:");
                    System.out.print("Director: ");
                    String newDirector = scanner.nextLine();
                    System.out.print("Year: ");
                    int newYear = getIntegerInput();
                    System.out.print("Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Is movie in color? Type yes or no: ");
                    String newColor = scanner.nextLine().toLowerCase();
                    boolean newIsInColor = newColor.equals("yes");
                    System.out.print("Length in minutes: ");
                    int newLengthInMinutes = getIntegerInput();

                    // Update new movie details:
                    m.setDirector(newDirector);
                    m.setYear(newYear);
                    m.setGenre(newGenre);
                    m.setColor(newIsInColor);
                    m.setLengthInMinutes(newLengthInMinutes);

                    System.out.println("domain_model.Movie details updated.");
                    System.out.println(m.toString());
                    hasFound = true;
                }
            }
            if (!hasFound) {
                System.out.println("No movies found to edit.");
            }
            System.out.println("Would you like to edit further? Type yes or no:");
            String userChoice = scanner.nextLine();
            continueEditing = userChoice.equalsIgnoreCase("yes");

            if (continueEditing) {
                System.out.print("Enter title to edit: ");
                title = scanner.nextLine();
            } else {
                System.out.println("Program has ended");
                // scanner.close(); // Avoid closing scanner to keep it open for further input
            }
        }
    }

    private String getStringInput() {
        return scanner.nextLine().trim();
    }

    private int getIntegerInput() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(getStringInput());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer value:");
            }
        }
        return value;
    }


    public String addMovie(String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {
        filmObjekter.add(new Movie(title, director, year, Color, lengthInMinutes, genre));
        return title + "was added to the collection!";

    }


    public void printMyCollection() {
        for (int i = 0; i < filmObjekter.size(); i++) {
            Movie m = filmObjekter.get(i);
            System.out.println(m.toString());
        }
    }

    public void printMovie(int i) {

        if (i < filmObjekter.size() && i >= 0) {
            System.out.println(filmObjekter.get(i));
        } else {
            System.out.println("Please enter a number between 0 " + "and " + filmObjekter.size());
        }
    }

    public void searchMovie(String title) {
        boolean hasFound = false;
        System.out.println("Search results can be seen below:");

        for (Movie m : filmObjekter) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(m);
                hasFound = true;
            }
        }
        if (!hasFound) {
            System.out.println("No matches found in movie collection");
        }
    }


    public Movie getMovie(int movieNumber) {
        return filmObjekter.get(movieNumber);
    }

    public ArrayList<Movie> getMovieCollectionList() {
        return filmObjekter;
    }

    public String removeMovie(String title) {
        for (int i = 0; i < filmObjekter.size(); i++) {
            Movie m = filmObjekter.get(i);
            if (m.getTitle().equalsIgnoreCase(title)) {
                filmObjekter.remove(i);
                return "Movie removed successfully.";
            }
        }
        return "Movie not found.";
    }
}

