package AdminModule;
import java.util.Scanner;

public class staffLogin {
    public static void main(String[] args) {
        int choice;
        String title;
        changeMovieApp app = new changeMovieApp();
        do{
            System.out.println("What would you like to do?");
            System.out.println("1: Add a new movie");
            System.out.println("2: Update an existing movie");
            System.out.println("3: Delete a movie");
            System.out.println("4: Configure system settings");
            System.out.println("5: Sign Out");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    //add movie
                    app.createMovie();
                    break;

                case 2:
                    //update movie
                    System.out.println("Enter the title of the movie");
                    title = sc.nextLine();
                    //find movie
                    app.updateMovie(null);
                    break;

                case 3:
                    //delete movie
                    System.out.println("Enter the title of the movie");
                    title = sc.nextLine();
                    //find movie
                    app.updateMovie(null);
                    break;

                case 4:
                    //configure settings (change ticket prices, holidays, movie type)
                    break;

                case 5:
                    //sign out
                    System.out.println("Signing out...");
                    break;
            }

        } while(choice != 5);

    }
}
