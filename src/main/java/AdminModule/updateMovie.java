package AdminModule;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import MovieGoerModule.Cineplex;
import MovieGoerModule.Movie;
import MovieGoerModule.Status;

public class updateMovie {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        update();
    }

    public static void update() throws ClassNotFoundException, IOException{
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        //print out list of cineplex
        ArrayList<Cineplex> cList = cineplexDB.getCineplexListFromFile();
        cineplexDB.printCineplexList();

        //select cineplex (enter name and get index)
        int cineplexindex;
        while(true){
            System.out.println("Enter the name of cineplex:");
            String nameCineplex = sc.nextLine();
            if(cineplexDB.isExistingCineplex(cList, nameCineplex)){
                cineplexindex = cineplexDB.getCineplexIndex(cList, nameCineplex);
                break;
            }
            else{
                System.out.println("Cineplex does not exist! Try again!");
            }
        }

        Cineplex chosenCineplex = cList.get(cineplexindex);
        ArrayList<Movie> movieList = chosenCineplex.getMovieList();
        if(movieList.size() < 1){
            System.out.println("No movies in this cineplex");
            return;
        }

        System.out.println("Movies in cineplex");
        for(int i = 0; i < movieList.size(); i++){
            System.out.println(i+1 + ": " + movieList.get(i).getTitle());
        }

        Movie chosenMovie;
        int movieIndex;
        while(true){
            System.out.println("Enter title of movie to update");
            String title = sc.nextLine();
            if(cineplexDB.isExistingMovie(movieList, title)){
                movieIndex = cineplexDB.getMovieIndex(movieList, title);
                chosenMovie = movieList.get(movieIndex);
                break;
            }
            else{
                System.out.println("Movie does not exist! Try again");
            }
        }

        System.out.println("original details:");
        chosenMovie.printDetails();

        do{
            System.out.println("What would you like to change?");
            System.out.println("1: Status");
            System.out.println("2: Done");
            choice = sc.nextInt();
                
            switch(choice){
                case 1:
                    System.out.println("Enter the status:");
                    System.out.println("1: COMING_SOON ");
                    System.out.println("2: PREVIEW");
                    System.out.println("3: NOW_SHOWING");
                    System.out.println("4: END_OF_SHOWING");
                    int set = sc.nextInt();
                    switch(set){
                        case 1:
                            chosenMovie.setStatus(Status.COMING_SOON);
                            break;
            
                        case 2:
                            chosenMovie.setStatus(Status.PREVIEW);
                            break;
            
                        case 3:
                            chosenMovie.setStatus(Status.NOW_SHOWING);
                            break;
            
                        case 4:
                            chosenMovie.setStatus(Status.END_OF_SHOWING);
                            break;

                        default:
                            System.out.println("Invalid input! Try again!");
                            break;
                    }
                    break;

                case 2:
                    chosenCineplex.setMovie(movieIndex, chosenMovie);
                    cList.set(cineplexindex, chosenCineplex);
                    cineplexDB.addCineplexListToFile(cList);
                    System.out.println("Done!");
                    System.out.println("Updated details:");
                    chosenMovie.printDetails();
                    break;

                default:
                    System.out.println("Invalid input! Try again!");
                    break;
            }

        } while(choice != 2);
    }
}
