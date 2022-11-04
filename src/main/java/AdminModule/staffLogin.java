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
            System.out.println("5: Sign Out");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    //add movie
                    createMovie.main(args);
                    break;

                case 2:
                    //update movie
                    //clear buffer
                    sc.nextLine();
                    updateMovie.main(args);;
                    break;

                case 3:
                    //delete movie
                    //clear buffer
                    sc.nextLine();
                    deleteMovie.main(args);;
                    break;

                case 4:
                    //configure settings (change ticket prices, holidays, movie type)
                    configureSettings.main(args);
                    break;

                case 5:
                    //sign out
                    System.out.println("Signing out...");
                    break;
            }
            
        } while(choice != 5);
        
        sc.close();
    }
}
