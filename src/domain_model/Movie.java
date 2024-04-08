package domain_model;

import java.util.Comparator;
import java.util.Objects;

public class Movie { //movie klasse med private attributter
    public static Comparator<Movie> COMPARATOR = Comparator.comparing(Movie::getTitle);
            //.thenComparing(Movie::getAge);
    private String title;
    private String director;
    private int year;
    private boolean Color;
    private int lengthInMinutes;
    private String genre;

    public Movie(String title, String director, int year, boolean isInColor, int lengthInMinutes, String genre) {
        this.title = title; //værdierne sættes af konstruktøreren
        this.director = director;
        this.year = year;
        this.Color = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    public String getTitle() { //værdier ud gennem getter-metoder
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public boolean getColor() {
        return Color;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(boolean color) {
        Color = color;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        String farve;
        if (this.getColor()) {
            farve = "The movie is in color\n";
        } else {
            farve = "The movie is in black & white\n";
        }
        return  "The title of the movie: " + this.getTitle() + "\n" +
                "The director of the movie: " + this.getDirector() + "\n" +
                "The year of the movie: " + this.getYear() + "\n" +
                farve +
                "The movie's length in minutes: " + this.getLengthInMinutes() + "\n" +
                "The genre of the movie: " + this.getGenre() + "\n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie film = (Movie) o;
        return Objects.equals(title, film.title) &&
                Objects.equals(director, film.director) &&
                Objects.equals(year, film.year) &&
                Objects.equals(Color, film.Color) &&
                Objects.equals(lengthInMinutes, film.lengthInMinutes) &&
                Objects.equals(genre, film.genre);
    }
    public String toCsvString() {
        return title + "," + director + "," + year + "," + Color + "," + lengthInMinutes + "," + genre;
    }

}
