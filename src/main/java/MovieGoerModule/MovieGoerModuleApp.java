package MovieGoerModule;

import java.util.Calendar;
import java.util.Scanner;

public class MovieGoerModuleApp {
    public String[] holidays = { "01/01/2022", "01/02/2022", "02/02/2022", "15/04/2022", "01/05/2022", "03/05/2022",
            "15/05/2022", "10/07/2022", "09/08/2022", "24/10/2022", "25/12/2022" };

    public static void main(String[] args) throws Exception {
        // Initialisation
        Calendar today = Calendar.getInstance();

        // Cineplex cathay = new Cineplex(3);
        // TimeSlot newSlot = new TimeSlot("02/11/2022", 1700);

        String Date1 = "31/10/2022";

        Movie movie1 = new Movie("Batman");
        Movie movie2 = new Movie("Joker");
        Movie movie3 = new Movie("Superman");

        Movie[] movieArr = new Movie[3];

        // *************************
        Scanner sc = new Scanner(System.in);

        System.out.println("********************");
        System.out.println("Movie Goer Module");
        System.out.println("1. Search/List movie");
        System.out.println("2. View Movie details");
        System.out.println("3. Seat Availability and Booking");
        System.out.println("4. View Booking History");
        System.out.println("5. List Top 5 Movies by sales OR by overall ratings");
        System.out.println("6. Exit");
        System.out.println("********************");

        int option = 0;
        do {
            System.out.println("Enter Option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Search/List movie");

                    break;
                case 2:
                    System.out.println("2. View Movie details");

                    break;
                case 3:
                    System.out.println("3. Seat Availability and Booking");
                    Calendar bookingDay = Calendar.getInstance();
                    bookingDay.set(2022, 10, 25); //
                    System.out.println("Which Day?");
                    System.out.println("Which Movie?");
                    System.out.println("Which time slot?");

                    break;
                case 4:
                    System.out.println("4. View Booking History");

                    break;

                case 5:
                    System.out.println("6. List Top 5 Movies by sales OR by overall ratings");

                    break;
                default:
                    break;
            }

        } while (option != 6);

    }
}
