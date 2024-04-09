package ui;

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
                String title = getTitle();
                movieController.searchMovie(title);
            } else if (userChoice == 5) {
                editMovie();
            } else if (userChoice == 6) {
                remove();
            } else if (userChoice >= sentinel) {
                System.out.println("Afsluttet");
            }
        }
    }

    private int movieMenu() {
        System.out.println("Welcome to my moviecollection!");
        System.out.println("1. Create a movie");
        System.out.println("2. Print the moviecollection");
        System.out.println("3. Print a single movie");
        System.out.println("4. Search movie");
        System.out.println("5. Edit movie");
        System.out.println("6. Remove movie");
        System.out.println("7. Close");
        int userChoice = scanner.nextInt();
        return userChoice;
    }

    private void addMovie() {
        System.out.println("input movie title");
        String title = scanner.next();

        System.out.println("input director");
        String director = scanner.next();

        System.out.println("input year created");
        int year = 0;
        boolean flag = false;
        while (!flag) {
            try {
                year = scanner.nextInt();
                flag = true;
            } catch (InputMismatchException first) {
                System.out.println("fail, try again");
                System.out.println("Input year created agian");
                scanner.nextLine();
            }
        }

        boolean color = false;
        System.out.println("is the movie in color? yes/no");
        String erIFarve = scanner.next();
        erIFarve = erIFarve.toLowerCase();
        if (erIFarve.equals("yes")) {
            color = true;
        }

        System.out.println("input length in minutes");
        int minute = 0;
        boolean flag1 = false;
        while (!flag1) {
            try {
                minute = scanner.nextInt();
                flag1 = true;
            } catch (InputMismatchException second) {
                System.out.println("fail, try again");
                System.out.println("Input length in minutes again");
                scanner.nextLine();
            }
        }

        System.out.println("input genre");
        String genre = scanner.next();

        movieController.addMovie(title, director, year, color, minute, genre);
    }

    private int getMovieNumber() {
        System.out.println("What nr. movie would you like to print?");
        int movieNumber = scanner.nextInt();
        return movieNumber;
    }

    private String getTitle() {
        System.out.println("What is the title of the movie you'd wish to search for?");
        String title = scanner.next();
        return title;
    }

    public void editMovie() {
        System.out.println("type the number of the movie you want to edit:");
        int movieNumber = scanner.nextInt();
        movieController.printMovie(movieNumber);
        Movie m = movieController.getMovie(movieNumber);


        System.out.println("Would you like to edit the title? Enter yes/no");
        String Edit;
        String titleEdit = m.getTitle();
        Edit = scanner.next();
        scanner.nextLine();
        if (Edit.equals("yes")) {
            System.out.println("Enter the new title;");
            titleEdit = scanner.nextLine();
            System.out.println("The new title is " + titleEdit);
            m.setTitle(titleEdit);
        } else {
            System.out.println("I will keep the title " + m.getTitle());
        }
        System.out.println("Would you like to edit the director? Enter yes/no");
        String directorEdit = m.getDirector();
        Edit = scanner.nextLine();
        if (Edit.equals("yes")) {
            System.out.println("Enter the new director: ");
            directorEdit = scanner.nextLine();
            System.out.println("The new director is " + directorEdit);
            m.setDirector(directorEdit);
        } else {
            System.out.println("I will keep the director " + m.getDirector());
        }
        System.out.println("Would you like to edit the year? Enter yes/no");
        int yearEdit = m.getYear();
        Edit = scanner.nextLine();
        if (Edit.equals("yes")) {
            System.out.println("enter the new year: ");
            yearEdit = scanner.nextInt();
            System.out.println("The new year is " + yearEdit);
            m.setYear(yearEdit);
        } else {
            System.out.println("I will keep the year " + m.getYear());
        }
        System.out.println("Would you like to edit the color? yes/no");
        Boolean colorEdit = m.getColor();
        Edit = scanner.nextLine();
        if (Edit.equals("yes")) {
            System.out.println("Type yes for color, no for black and white");
            String colorEditString = scanner.nextLine();
            if (colorEditString.equals("yes")) {
                m.setColor(true);
                colorEdit = true;
                System.out.println("The movie is now in color");
            } else {
                m.setColor(false);
                colorEdit = false;
                System.out.println("The movie is now in black and white");
            }
        } else {
            System.out.println("I will keep the colorsetting");
            colorEdit = m.getColor();
        }
        System.out.println("Would you like to edit the length in minutes? Enter yes/no");
        int lengthEdit = m.getLengthInMinutes();
        Edit = scanner.nextLine();
        if (Edit.equals("yes")) {
            System.out.println("type the new length in minutes:");
            lengthEdit = scanner.nextInt();
            System.out.println("The new length is " + lengthEdit);
            m.setLengthInMinutes(lengthEdit);
        } else {
            System.out.println("I will keep the length " + m.getLengthInMinutes() + " minutes long");
        }


        System.out.println("Would you like to edit the genre? Enter yes/no");
        String genreEdit = m.getGenre();
        Edit = scanner.nextLine();
        if (Edit.equals("yes")) {
            System.out.println("type the new genre");
            genreEdit = scanner.nextLine();
            System.out.println("The new genre is " + genreEdit);
            m.setGenre(genreEdit);
        } else {
            System.out.println("I will keep the genre " + m.getGenre());
        }
        movieController.editMovie(movieNumber, titleEdit, directorEdit, yearEdit, colorEdit, lengthEdit, genreEdit);
    }

    public void remove() {
        System.out.println("What is the title of the movie you'd like to remove?");
        String title = scanner.next();
        System.out.println(movieController.removeMovie(title));
    }

    private Comparator<Movie> getSortOption() {
        System.out.println("select an option to sort by:");
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. Year");
        System.out.println("4. Color");
        System.out.println("5. Length");
        System.out.println("6. Genre");

        int userInput = scanner.nextInt();

        switch (userInput) {
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


