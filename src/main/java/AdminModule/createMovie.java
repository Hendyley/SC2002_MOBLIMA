package AdminModule;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.time.Duration;
import java.util.Scanner;
import java.util.ArrayList;

import MovieGoerModule.AgeOfMovieGoer;
import MovieGoerModule.Cineplex;
import MovieGoerModule.Movie;
import MovieGoerModule.TypeOfMovie;
import MovieGoerModule.Status;

public class createMovie{
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        create();
    }

    public static void create() throws ClassNotFoundException, IOException{
        //search cineplex for movie
        //check if inside cineplex then return
        //else check in global
        //if not in global, create and then add to global and local
        //else add inside local

        //print out list of cineplex
        String title;
        Scanner sc = new Scanner(System.in);
        ArrayList<Cineplex> cList = cineplexDB.getCineplexListFromFile();
        cineplexDB.printCineplexList();


        //select cineplex (enter name and get index)
        int cineplexindex;
        Cineplex chosenCineplex;
        while(true){
            System.out.println("Enter the name of cineplex:");
            String nameCineplex = sc.nextLine();
            if(cineplexDB.isExistingCineplex(cList, nameCineplex)){
                cineplexindex = cineplexDB.getCineplexIndex(cList, nameCineplex);
                chosenCineplex = cList.get(cineplexindex);
                break;
            }
            else{
                System.out.println("Cineplex does not exist! Try again!");
            }
        }

        ArrayList<Movie> movieList = chosenCineplex.getMovieList();
        while(true){
            System.out.println("Enter movie title:");
            title = sc.nextLine();
            if(cineplexDB.isExistingMovie(movieList, title)){
                System.out.println("Movie already in cineplex");
                System.out.println("Returning...");
                return;
            }
            else{
                System.out.println("Movie not in cineplex!");
                break;
            }
        }

        //check in global DB, if inside then add to cineplex
        ArrayList<Movie> movieDBList = MovieDB.getMovieListFromFile();
        if(MovieDB.isExistingMovie(movieList,title)){
            System.out.println("Movie in database");
            int index = MovieDB.getMovieIndex(movieList, title);
            Movie toAdd = movieList.get(index);
            chosenCineplex.addMovie(toAdd);
            cList.set(cineplexindex, chosenCineplex);
            System.out.println("Adding movie from database into cineplex...");
            cineplexDB.addCineplexListToFile(cList);
            return;
        }
        else{
            System.out.println("Movie does not exist");
        }

        String director, sypnosis;
        ArrayList<String> castList = new ArrayList<String>();
        Status status = Status.PREVIEW;
        TypeOfMovie type = TypeOfMovie.BLOCKBUSTER_2D;
        int movieDuration = 0;
        AgeOfMovieGoer restriction = AgeOfMovieGoer.ADULT;

        //type of movie
        System.out.println("Enter the type of movie");
        System.out.println("1: REGULAR_2D");
        System.out.println("2: REGULAR_3D");
        System.out.println("3: BLOCKBUSTER_2D");
        System.out.println("4: BLOCKBUSTER_3D");
        int choice = sc.nextInt();
        sc.nextLine();      //clear buffer
        switch(choice){
            case 1:
                type = TypeOfMovie.REGULAR_2D;
                break;

            case 2:
                type = TypeOfMovie.REGULAR_3D;
                break;

            case 3:
                type = TypeOfMovie.BLOCKBUSTER_2D;
                break;

            case 4:
                type = TypeOfMovie.BLOCKBUSTER_3D;
                break;
        }

        //director
        System.out.println("Enter the director's name:");
        director = sc.nextLine();

        //cast
        //do while loop for entering multiple cast
        //check for minimum 2 casts
        System.out.println("Enter the cast: (0 to exit)");
        while(true){
            String cast = sc.nextLine();
            if(cast.equals("0")) break;
            castList.add(cast);
        }

        //status
        do{
            System.out.println("Enter the status:");
            System.out.println("1: COMING_SOON ");
            System.out.println("2: PREVIEW");
            System.out.println("3: NOW_SHOWING");
            System.out.println("4: END_OF_SHOWING");
            choice = sc.nextInt();
            sc.nextLine();      //clear buffer
            switch(choice){
                case 1:
                    status = Status.COMING_SOON;
                    break;

                case 2:
                    status = Status.PREVIEW;
                    break;

                case 3:
                    status = Status.NOW_SHOWING;
                    break;

                case 4:
                    status = Status.END_OF_SHOWING;
                    break;
                
                case 5:
                    System.out.println("Invalid input!");
                    break;
            }
        } while(choice < 1 || choice > 4);

        //sypnosis
        System.out.println("Enter the sypnosis:");
        sypnosis = sc.nextLine();

        //duration
        System.out.println("Enter the duration of the movie");
        while(true){
            movieDuration = sc.nextInt();
            if(movieDuration <= 0 || movieDuration > 480)
                System.out.println("Invalid duration");
            else break;
        }

        //age
        do{
            System.out.println("Choose the age restriction");
            System.out.println("1: ADULT");
            System.out.println("2: CHILD");
            System.out.println("3: SENIOR");
            System.out.println("4: STUDENT");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    restriction = AgeOfMovieGoer.ADULT;
                    break;

                case 2:
                    restriction = AgeOfMovieGoer.CHILD;
                    break;

                case 3:
                    restriction = AgeOfMovieGoer.SENIOR;
                    break;

                case 4:
                    restriction = AgeOfMovieGoer.STUDENT;
                    break;

                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while(choice < 1 || choice > 4);
        
        Movie toAdd = new Movie(title, director, castList, sypnosis, status, type, movieDuration, restriction);

        //add into database
        movieList.add(toAdd);
        System.out.println("Adding movie into database...");
        MovieDB.addMovieListToFile(movieList);
        MovieDB.printMovieList();

        //add into cineplex
        chosenCineplex.addMovie(toAdd);
        cList.set(cineplexindex, chosenCineplex);
        System.out.println("Adding movie into cineplex...");
        cineplexDB.addCineplexListToFile(cList);

        System.out.println("Movie successfully added!");
        toAdd.printDetails();

    }
}
