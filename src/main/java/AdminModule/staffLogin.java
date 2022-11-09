package AdminModule;

import java.io.IOException;
import java.util.Scanner;

public class staffLogin {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("What would you like to do?");
            System.out.println("1: Add a new movie");
            System.out.println("2: Update an existing movie");
            System.out.println("3: Delete a movie");
            System.out.println("4: Configure system settings");
            System.out.println("5: View movies");
            System.out.println("6: View Top 5 Movies");
            System.out.println("7: Sign Out");
            choice = sc.nextInt();
            sc.nextLine(); //clear buffer

            switch(choice){
                case 1:
                    //add movie
                    createMovie.create();
                    break;

                case 2:
                    //update movie
                    updateMovie.update();
                    break;

                case 3:
                    //delete movie
                    deleteMovie.delete();
                    break;

                case 4:
                    //configure settings (change ticket prices, holidays, movie type)
                    configureSettings.configure();
                    break;

                case 5:
                    //view all movies
                    MovieDB.printMovieList();
                    break;

                case 6:
                    //view top
                    // viewTop.top5();
                    break;

                case 7:
                    //sign out
                    System.out.println("Signing out...");
                    break;

                default:
                    //invalid input
                    System.out.println("Invalid input! Try again!");
                    break;
            }
            
        } while(choice != 7);
        
    }
}
