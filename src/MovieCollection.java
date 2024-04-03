import java.util.ArrayList;
//sætter nye værdier ind

public class MovieCollection {
    protected ArrayList<Movie> filmObjekter;

    public MovieCollection() {
        filmObjekter = new ArrayList<>();
        //filmObjekter.add(new Movie("hunger games", "james", 2002, true, 120, "science fiction"));
        //filmObjekter.add(new Movie("harry potter", "harry", 2002, true, 120, "science fiction"));
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
        int count = 0; //tæller antal fim der opfylder search
        System.out.println("Search results below:");
        for (Movie m: filmObjekter) { //for hvert movie objekt m i filmobjekter
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) { //tolowercase for bedre sø
                count++; //increments count med 1
                System.out.println(m.toString()); //printer movie detaljer
            }
        }
        if (count == 0) { //if count 0=no movies found.
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

