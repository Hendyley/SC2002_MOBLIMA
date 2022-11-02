package MovieGoerModule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MovieGoerModuleApp {
    public String[] holidays = { "01/01/2022", "01/02/2022", "02/02/2022", "15/04/2022", "01/05/2022", "03/05/2022",
            "15/05/2022", "10/07/2022", "09/08/2022", "24/10/2022", "25/12/2022" };

    public static void main(String[] args) throws Exception {
        // Initialisation
        Calendar today = Calendar.getInstance();

        Cineplex cineleisure = new Cineplex(3, "Cineleisure");
        TimeSlot newSlot = new TimeSlot("02/11/2022", 1700, TypeOfMovie.REGULAR_2D, ClassOfCinama.PLATINUM);

        String Date1 = "31/10/2022";

        int numOfMovies = 3;
        Movie movie1 = new Movie("Batman");
        Movie movie2 = new Movie("Joker");
        Movie movie3 = new Movie("Superman");

        Movie[] movieArr = new Movie[numOfMovies];
        movieArr[0] = movie1;
        movieArr[1] = movie2;
        movieArr[2] = movie3;

        // *************************
        Scanner sc = new Scanner(System.in);

        System.out.println("********************");
        System.out.println("Movie Goer Module");
        System.out.println("1. List Movies and View Movie Details");
        System.out.println("2. Seat Availability and Booking");
        System.out.println("3. View Booking History");
        System.out.println("4. List Top 5 Movies by sales OR by overall ratings");
        System.out.println("5. Exit");
        System.out.println("********************");

        int option = 0;
        do {
            System.out.println("Enter Option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Search/List movie");

                    for (int i = 1; i < numOfMovies + 1; i++) {
                        System.out.println(i + ". " + movieArr[i - 1].getTitle());
                    }
                    System.out.println("Select Movie to view details");
                    int movieSelection = sc.nextInt();
                    movieArr[movieSelection - 1].printDetails();
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Seat Availability and Booking");
                    System.out.println("Which Day?");
                    System.out.println("Which Movie?");
                    System.out.println("Which time slot?");

                    break;
                case 3:
                    System.out.println("View Booking History");

                    break;

                case 4:
                    System.out.println("List Top 5 Movies by sales OR by overall ratings");

                    break;
                default:
                    break;
            }

        } while (option != 5);

    }
}
