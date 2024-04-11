package domain_model;
import java.util.ArrayList;
import java.util.Comparator;
public class MovieCollection {
    protected ArrayList<Movie> filmObjekter;

    public MovieCollection() {
        filmObjekter = new ArrayList<>();
    }
    public void sortMoviesBy(Comparator<Movie> movieCompare) {
        filmObjekter.sort(movieCompare);
    }

    public void addMovie(String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {
        filmObjekter.add(new Movie(title, director, year, Color, lengthInMinutes, genre));

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
            System.out.println("Venligst indtast et nummer mellem 0 " + "og " + filmObjekter.size());
        }
    }

    public int searchMovie(String title) {
        int count = 0;
        System.out.println("Search results below:");
        for (Movie m: filmObjekter) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                count++;
                System.out.println(m.toString());
            }
        }
        if (count == 0) {
            System.out.println("No movies found with the given title.");
        }
        return count;
    }

    public void editMovie(int i, String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {
        Movie m = filmObjekter.get(i);
        m.setTitle(title);
        m.setDirector(director);
        m.setYear(year);
        m.setColor(Color);
        m.setLengthInMinutes(lengthInMinutes);
        m.setGenre(genre);
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

