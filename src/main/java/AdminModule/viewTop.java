package AdminModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import MovieGoerModule.Movie;
import MovieGoerModule.Review;

public class viewTop {
    public static void top5() throws ClassNotFoundException, IOException{

        //get movieList
        //likely to have duplicate
        //sales and ratings
        //use movieDB to get sales and ratings
        // ArrayList<Movie> movieList = MovieDB.getMovieListFromFile();

        // Scanner sc = new Scanner(System.in);
        // int choice = 0;
        // do{
        //     System.out.println("Enter a choice:");
        //     System.out.println("1: View by rating");
        //     System.out.println("2: View by sales");
        //     System.out.println("3: Back");
        //     choice = sc.nextInt();
        //     sc.nextLine();  //clear buffer
        //     switch(choice){
        //         case 1: //view by rating
        //         //sorting
        //             for(int i = 1; i < movieList.size(); i++){
        //                 for(int j = i; j > 0; j--){
        //                     if(movieList.get(j).getrealrating() < movieList.get(j-1).getrealrating()){
        //                         Collections.swap(movieList, j, j-1);
        //                     }
        //                     else break;
        //                 }
        //             }
        //             //print
        //             System.out.println("Listing top 5 movies by ratings:");
        //             for(int i = 0; i < movieList.size(); i++){
        //                 System.out.println(i+1 + ": " + movieList.get(i).getTitle());
        //             }
        //             System.out.println();

        //             break;  //break case

        //         case 2: //view by sales
        //             //sorting
        //             for(int i = 1; i < movieList.size(); i++){
        //                 for(int j = i; j > 0; j--){
        //                     if(movieList.get(j).getSales() < movieList.get(j-1).getSales()){
        //                         Collections.swap(movieList, j, j-1);
        //                     }
        //                     else break;
        //                 }
        //             }
        //             //print
        //             System.out.println("Listing top 5 movies by sales:");
        //             for(int i = 0; i < movieList.size(); i++){
        //                 System.out.println(i+1 + ": " + movieList.get(i).getTitle());
        //             }
        //             System.out.println();
        //             break; //break case

        //         case 3:
        //             System.out.println("Going back...");
        //             System.out.println();
        //             break;

        //         default:
        //             System.out.println("Invalid input!");
        //             break;

        //     }
        // } while(choice != 3);
        

        ArrayList<Movie> top5m = MovieDB.getMovieListFromFile();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. View by sales");
            System.out.println("2. View by rating");
            System.out.println("3: Back");
            choice = sc.nextInt();
            sc.nextLine();  //clear buffer

            switch (choice) {
                case 1:
                    // Sort by sales only
                    Movie keyss;
                    int js;
                    for (int i = 1; i < top5m.size(); i++) {
                        keyss = top5m.get(i);
                        js = i - 1;
                        while (js >= 0 && top5m.get(js).getSales() < keyss.getSales()) {
                            top5m.set(js + 1,top5m.get(js));
                            js = js - 1;
                        }
                        top5m.set(js + 1,keyss);
                    }
                    break;

                case 2:
                    // Sort by Rating only
                    Movie keys;
                    int j;
                    for (int i = 1; i < top5m.size(); i++) {
                        keys = top5m.get(i);
                        j = i - 1;
                        while (j >= 0 && top5m.get(j).getrealrating() < keys.getrealrating()) {
                            top5m.set(j + 1,top5m.get(j));
                            j = j - 1;
                        }
                        top5m.set(j+1,keys);
                    }
                    break;

                case 3:
                    System.out.println("Going back...");
                    System.out.println();
                    return;

                 default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (choice < 1 || choice > 2);
        

        System.out.println("Here are the top 5 list: ");
        int n = 5;
        if (top5m.size() < 5) {
            n = top5m.size();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + " Movie: " + top5m.get(i).getTitle() + " Rating: " + top5m.get(i).getRating()
                    + " Sales: " + top5m.get(i).getSales() + " Number of reviewer: "
                    + top5m.get(i).getnumberofreviewer());
        }
        System.out.println("Select movie to view review comment");
        choice=sc.nextInt();
        if(choice>=n || choice<0){
            //System.out.println("Sorry, please select input appropriate value");
            return;
        }
        ArrayList<Review> tempreview = top5m.get(choice).getreviewlist();
        for(int i=0;i<tempreview.size();i++){
            System.out.println("Comment "+i+": "+tempreview.get(i).getRemark());
        }

        return;

    }
}
