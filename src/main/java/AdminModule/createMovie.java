package AdminModule;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import MovieGoerModule.Movie;
import MovieGoerModule.TypeOfMovie;
import MovieGoerModule.Status;

public class createMovie{
    public static void create() throws ClassNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of the movie:");
        String title = sc.nextLine();

        ArrayList<Movie> movieList = MovieDB.getMovieListFromFile();
        if(MovieDB.isExistingMovie(movieList,title)){
            System.out.println("Movie Title already existed");
            return;
        }

        Movie m = new Movie(title);

        System.out.println("Enter the type of movie");
        System.out.println("1: REGULAR_2D");
        System.out.println("2: REGULAR_3D");
        System.out.println("3: BLOCKBUSTER_2D");
        System.out.println("4: BLOCKBUSTER_3D");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                m.setType(TypeOfMovie.REGULAR_2D);
                break;

            case 2:
                m.setType(TypeOfMovie.REGULAR_3D);
                break;

            case 3:
                m.setType(TypeOfMovie.BLOCKBUSTER_2D);
                break;

            case 4:
                m.setType(TypeOfMovie.BLOCKBUSTER_3D);
                break;
        }
        //clear buffer
        sc.nextLine();

        System.out.println("Enter the director's name:");
        String director = sc.nextLine();
        m.setDirector(director);

        //do while loop for entering multiple cast
        System.out.println("Enter the cast: (0 to exit)");
        while(true){
            String cast = sc.nextLine();
            if(cast.equals("0")) break;
            m.addCast(cast);
        }

        System.out.println("Enter the status:");
        System.out.println("1: COMING_SOON ");
        System.out.println("2: PREVIEW");
        System.out.println("3: NOW_SHOWING");
        System.out.println("4: END_OF_SHOWING");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                m.setStatus(Status.COMING_SOON);
                break;

            case 2:
                m.setStatus(Status.PREVIEW);
                break;

            case 3:
                m.setStatus(Status.NOW_SHOWING);
                break;

            case 4:
                m.setStatus(Status.END_OF_SHOWING);
                break;
        }
        //clear buffer
        sc.nextLine();

        System.out.println("Enter the sypnosis:");
        String sypnosis = sc.nextLine();
        m.setSynopsis(sypnosis);

        //add time slots?

        movieList.add(m);
        MovieDB.addMovieListToFile(movieList);
        MovieDB.printMovieList();

        System.out.println("Movie successfully added!");
        m.printDetails();

    }
}
