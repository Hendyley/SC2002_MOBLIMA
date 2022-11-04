package MovieGoerModule;

import java.util.ArrayList;

public class Cineplex {
    private String name;
    private Cinema[] room;
    private ArrayList<Movie> listOfMovies = new ArrayList<Movie>();

    public Cineplex(int numRooms, String name) {
        this.name = name;

        room = new Cinema[numRooms];
        for (int i = 0; i < numRooms; i++) {
            room[i] = new Cinema();
        }
    }

    public Cinema getRoom(int i) {
        return this.room[i];
    }

    public String getName() {
        return this.name;
    }

    public void addMovie(Movie movie) {
        listOfMovies.add(movie);
    }

    public ArrayList<Movie> getMovieList() {
        return listOfMovies;
    }
}
