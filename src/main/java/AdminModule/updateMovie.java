package AdminModule;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import MovieGoerModule.Movie;
import MovieGoerModule.Status;

public class updateMovie {
    public static void main(String[] args) throws ClassNotFoundException, IOException{
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Movie> movieList;
        int index = -1;

        String title = sc.nextLine();
        movieList = MovieDB.getMovieListFromFile();
        index = MovieDB.getMovieIndex(movieList, title);
        if(index < 0){
            System.out.println("Movie does not exist");
            return;
        }

        Movie m = movieList.get(index);
        System.out.println("original details:");
        m.printDetails();


        do{
            System.out.println("What would you like to change?");
            System.out.println("1: Status");
            System.out.println("2. Time slots");
            System.out.println("3: Done");
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
                    break;

                case 2:
                    //TIMESLOTS
                    break;

                case 3:
                    movieList.set(index,m);    
                    MovieDB.addMovieListToFile(movieList);
                    MovieDB.printMovieList();

                    System.out.println("Done!");
                    System.out.println("Updated details:");
                    m.printDetails();
                    break;
            }

        } while(choice != 3);
    }
}
