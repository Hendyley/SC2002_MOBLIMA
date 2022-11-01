package MovieGoerModule;

import java.util.Scanner;

public class MovieGoerModuleApp {
    public static void main(String[] args) {
        // Initialisation
        Cineplex cathay = new Cineplex(3);

        Day day;
        int TimeSlot; // we use 24h timing. 5pm = 1700;
        int numOfMovies = 3;
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
        System.out.println("3. Seat Availability and Selection of Seats");
        System.out.println("4. Book and Purhcase Tickets");
        System.out.println("5. View Booking History");
        System.out.println("6. List Top 5 Movies by sales OR by overall ratings");
        System.out.println("7. Exit");
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
                    System.out.println("3. Seat Availability and Selection of Seats");
                    System.out.println("Which Day?");
                    System.out.println("Which Movie?");
                    System.out.println("Which time slot?");

                    break;
                case 4:
                    System.out.println("4. Book and Purchase Tickets");

                    break;
                case 5:
                    System.out.println("5. View Booking History");

                    break;
                case 6:
                    System.out.println("6. List Top 5 Movies by sales OR by overall ratings");

                    break;
                default:
                    break;
            }

        } while (option != 7);

    }
}
