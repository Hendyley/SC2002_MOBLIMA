package MovieGoerModule;

import java.util.Scanner;

public class MovieGoerModuleApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;
        do {
            System.out.println("Movie Goer Module");
            System.out.println("1. Search/List movie");
            System.out.println("2. View Movie details");
            System.out.println("3. Seat Availability and Selection of Seats");
            System.out.println("4. Book and Purhcase Tickets");
            System.out.println("5. View Booking History");
            System.out.println("6. List Top 5 Movies by sales OR by overall ratings");
            System.out.println("7. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }

        } while (option != 7);

    }
}
