package AdminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import MovieGoerModule.Movie;

public class MovieDB {
    private final static String MOVIE_FILE_NAME = "Movie.txt";

    public static ArrayList<Movie> getMovieListFromFile() throws IOException, ClassNotFoundException{
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        try{
            FileInputStream fileInputStream2 = new FileInputStream(MOVIE_FILE_NAME);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            movieList = (ArrayList<Movie>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Movie List retrieved from File");           
        }catch(FileNotFoundException e){
            FileOutputStream fileOutputStream = new FileOutputStream(MOVIE_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            movieList = generateDummyData();
            objectOutputStream.writeObject(movieList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Movie List File not found, creating new Movie List File");           
        }

        return movieList;
    }

    public static void addMovieListToFile(ArrayList<Movie> movieList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(MOVIE_FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(movieList);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.printf("Movie Lists added to File\n");
    }

    public static boolean isExistingMovie(ArrayList<Movie> movieList, String newMovieTitle){
        for(Movie m: movieList){
            if(m.getTitle().equals(newMovieTitle)){
                return true;
            }
        }
        return false;
    }

    public static int getMovieIndex(ArrayList<Movie> movieList, String title){
        String currentTitle = "";
        for(int i = 0; i < movieList.size(); i++){
           currentTitle = movieList.get(i).getTitle();
           if(currentTitle.equals(title)){
                return i;
           };
        }
        return -1;
    }

    public static void printMovieList() throws ClassNotFoundException, IOException{
        ArrayList<Movie> movieList = getMovieListFromFile();

        System.out.println();
        System.out.println("Printing out Movie List");
        for(Movie m : movieList){
            m.printDetails();
            System.out.printf("Ticket Sales: %s, ", m.getSales());
            System.out.printf("All Reviews: %s",m.getreviewlist());
            System.out.printf("All Time Slots: %s",m.getTimeSlots());
        }
        System.out.printf("\n\n");

    }

    public static void printMovies() throws ClassNotFoundException, IOException{
        ArrayList<Movie> movieList = getMovieListFromFile();

        System.out.println();
        System.out.println("Printing out Movie List");
        for(int i = 0; i < movieList.size(); i++){
            System.out.println(i+1 + ": " + movieList.get(i).getTitle());
        }

    }


    private static ArrayList<Movie> generateDummyData(){
        ArrayList<Movie> movieList = new ArrayList<>();
        Movie movie;
    
        movie = new Movie("ONE PIECE FILM RED");
        movieList.add(movie);
    
        movie = new Movie("Kung Fu Hustle");
        movieList.add(movie);
    
        return movieList;
    }
}
