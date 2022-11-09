package AdminModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import MovieGoerModule.Movie;

public class viewTop {
    public static void top5() throws ClassNotFoundException, IOException{

        //get movieList
        //likely to have duplicate
        //sales and ratings
        //use movieDB to get sales and ratings
        ArrayList<Movie> movieList = MovieDB.getMovieListFromFile();

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("Enter a choice:");
            System.out.println("1: View by rating");
            System.out.println("2: View by sales");
            System.out.println("3: Back");
            choice = sc.nextInt();
            sc.nextLine();  //clear buffer
            switch(choice){
                case 1: //view by rating
                //sorting
                    for(int i = 1; i < movieList.size(); i++){
                        for(int j = i; j > 0; j--){
                            if(movieList.get(j).getrealrating() < movieList.get(j-1).getrealrating()){
                                Collections.swap(movieList, j, j-1);
                            }
                            else break;
                        }
                    }
                    //print
                    System.out.println("Listing top 5 movies by ratings:");
                    for(int i = 0; i < movieList.size(); i++){
                        System.out.println(i+1 + ": " + movieList.get(i).getTitle());
                    }
                    System.out.println();

                    break;  //break case

                case 2: //view by sales
                    //sorting
                    for(int i = 1; i < movieList.size(); i++){
                        for(int j = i; j > 0; j--){
                            if(movieList.get(j).getSales() < movieList.get(j-1).getSales()){
                                Collections.swap(movieList, j, j-1);
                            }
                            else break;
                        }
                    }
                    //print
                    System.out.println("Listing top 5 movies by sales:");
                    for(int i = 0; i < movieList.size(); i++){
                        System.out.println(i+1 + ": " + movieList.get(i).getTitle());
                    }
                    System.out.println();
                    break; //break case

                case 3:
                    System.out.println("Going back...");
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid input!");
                    break;

            }
        } while(choice != 3);

    }
}
