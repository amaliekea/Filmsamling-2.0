package ui;
// information expert
// single responsibility princip

import domain_model.Controller;
import domain_model.Movie;

import java.util.*;

import domain_model.TitleComparator;
import domain_model.DirectorComparator;
import domain_model.YearComparator;
import domain_model.ColorComparator;
import domain_model.LengthComparator;
import domain_model.GenreComparator;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Controller movieController = new Controller();

    public void startProgram() {
        int userChoice = 0;
        int sentinel = 7;
        movieController.loadMovies();
        while (userChoice < sentinel) {
            userChoice = movieMenu();

            if (userChoice == 1) {
                addMovie();

            } else if (userChoice == 2) {
                movieController.printCollection(getSortOption());
            } else if (userChoice == 3) {
                int movieNumber = getMovieNumber();
                movieController.printMovie(movieNumber);

            } else if (userChoice == 4) {
                searchMovie();
            } else if (userChoice == 5) {
                editMovie();
            } else if (userChoice == 6) {
                remove();
            } else if (userChoice >= sentinel) {
                System.out.println("------------------------------------------------------");
                System.out.println("              Exiting Movie Collection                ");
                System.out.println("------------------------------------------------------");

            }
        }
    }

    private int movieMenu() {
        boolean inputValid;
        int userChoice = -1;
        do {
            try {
                System.out.println("Welcome to my moviecollection!");
                System.out.println("1. Create a movie");
                System.out.println("2. Print the moviecollection");
                System.out.println("3. Print a single movie");
                System.out.println("4. Search movie");
                System.out.println("5. Edit movie");
                System.out.println("6. Remove movie");
                System.out.println("7. Close");
                userChoice = scanner.nextInt();
                inputValid = true;

            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer.");
                scanner.nextLine(); // Clear the scanner input
                inputValid = false;
            }
        } while (!inputValid);
        scanner.nextLine();
        return userChoice;
    }

    private void addMovie() {
        System.out.println("---------Add film details below---------");

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Director: ");
        String director = scanner.nextLine();

        System.out.print("Year: ");
        int year = getIntegerInput();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Is the movie in color? Type yes/no: ");
        boolean color = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Length in minutes: ");
        int minute = getIntegerInput();

        movieController.addMovie(title, director, year, color, minute, genre);
    }


    private int getMovieNumber() {

        System.out.println("What nr. movie would you like to print?");
        int movieNumber = scanner.nextInt();
        scanner.nextLine();   // Consume newline character
        return movieNumber;
    }

    private void searchMovie() {
        System.out.print("Enter search: ");
        String search = scanner.nextLine();
        movieController.searchMovie(search);
    }

    private String getStringInput() {
        try {
            String inputString = scanner.nextLine().trim().toLowerCase();
            if (inputString.isEmpty()) {
                System.out.println("That didn't work. Try again.");
                return getStringInput();
            }
            return inputString;
        } catch (InputMismatchException e) {
            System.out.println("That didn't work. Try again.");
            scanner.nextLine(); // Consume the invalid input
            return getStringInput();
        }
    }

    private void editMovie() {
        System.out.print("Enter title to edit: ");
        String edit = scanner.nextLine();
        movieController.editMovie(edit);
    }
    private int getIntegerInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private double getDoubleInput() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }



    public void remove() {
        System.out.println("What is the title of the movie you'd like to remove?");
        String title = scanner.next();
        System.out.println(movieController.removeMovie(title));
    }

    private Comparator<Movie> getSortOption() {
        System.out.println("select a primary option to sort by:");
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. Year");
        System.out.println("4. Color");
        System.out.println("5. Length");
        System.out.println("6. Genre");

        int primary = scanner.nextInt();

        System.out.println("select a secondary option to sort by:");
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. Year");
        System.out.println("4. Color");
        System.out.println("5. Length");
        System.out.println("6. Genre");

        int secondary = scanner.nextInt();

        Comparator<Movie> primaryComparator = getComparatorOption(primary);
        Comparator<Movie> secondaryComparator = getComparatorOption(secondary);

        return primaryComparator.thenComparing(secondaryComparator);


    }


    Comparator<Movie> getComparatorOption(int option) {
        switch (option) {
            case 1:
                return new TitleComparator();
            case 2:
                return new DirectorComparator();
            case 3:
                return new YearComparator();
            case 4:
                return new ColorComparator();
            case 5:
                return new LengthComparator();
            case 6:
                return new GenreComparator();
            default:
                System.out.println("invalid option, default to title");
                return new TitleComparator();
        }
    }


}


