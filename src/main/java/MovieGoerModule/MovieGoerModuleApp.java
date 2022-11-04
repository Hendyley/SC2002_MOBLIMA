package MovieGoerModule;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MovieGoerModuleApp {

    public String[] holidays = { "2022-01-01", "2022-02-01", "2022-02-02", "2022-04-15", "2022-05-01", "2022-05-03",
            "2022-05-15", "2022-05-15", "2022-07-10", "2022-09-09", "2022-10-24", "2022-12-25" };

    private static final DecimalFormat df = new DecimalFormat("0.0");

    public static void main(String[] args) throws Exception {
        // Initialisation
        Calendar today = Calendar.getInstance();

        // Cineplex cathay = new Cineplex(3);
        // TimeSlot newSlot = new TimeSlot("2022-02-20", 1700, 1800,
        // ClassOfCinama.PLATINUM);

        String Date1 = "31/10/2022";

        Movie movie1 = new Movie("Batman");
        Movie movie2 = new Movie("Joker");
        Movie movie3 = new Movie("Superman");

        Movie[] movieArr = new Movie[3];
        movieArr[0] = new Movie("Batman");
        movieArr[1] = new Movie("Joker");
        movieArr[2] = new Movie("Superman");

        // *************************
        Scanner sc = new Scanner(System.in);

        System.out.println("********************");
        System.out.println("Movie Goer Module");
        System.out.println("1. Search/List movie");
        System.out.println("2. View Movie details");
        System.out.println("3. Seat Availability and Booking");
        System.out.println("4. Book a ticket");
        System.out.println("5. View Booking History");
        System.out.println("6. List Top 5 Movies by sales OR by overall ratings");

        System.out.println("7. Give a movie review");
        System.out.println("8. Exit");
        System.out.println("********************");

        int option = 0;
        do {
            System.out.println("Enter Option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Search/List movie");
                    for (int i = 0; i < movieArr.length; i++) {
                        System.out.println(i + " Movie " + movieArr[i].getTitle());
                    }

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

                    break;
                case 5:
                    System.out.println("4. View Booking History");

                    break;

                case 6:
                    System.out.println("6. List Top 5 Movies by sales OR by overall ratings");

                    // array for sorting
                    Movie[] top5m = movieArr;
                    System.out.println("1. by sales");
                    System.out.println("2. by rating");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            // Sort by sales only
                            break;
                        case 2:
                            // Sort by Rating only
                            Movie key;
                            int j;
                            for (int i = 1; i < top5m.length; i++) {
                                key = top5m[i];
                                j = i - 1;
                                while (j >= 0 && top5m[j].getRating() < key.getRating()) {
                                    top5m[j + 1] = top5m[j];
                                    j = j - 1;
                                }
                                top5m[j + 1] = key;
                            }
                            break;
                    }
                    System.out.println("Here are the top 5 list: ");
                    for (int i = 0; i < top5m.length; i++) {
                        ArrayList<Review> reviewlist = top5m[i].getreviewlist();
                        double num = movieArr[i].getRating();
                        String word = "Nan";
                        if (num > 0 && reviewlist.size() > 1) {
                            System.out.println(i + " Movie: " + top5m[i].getTitle() + " Rating: "
                                    + df.format(top5m[i].getRating()) + " Sales: " + top5m[i].getSales()
                                    + " Number of reviewer: " + reviewlist.size());
                        } else {
                            System.out.println(i + " Movie: " + top5m[i].getTitle() + " Rating: Nan Sales: "
                                    + top5m[i].getSales() + " Number of reviewer: " + reviewlist.size());
                        }

                    }
                    break;
                case 7:
                    System.out.println("7. Give a movie review");
                    System.out.println("List of all current movie");
                    for (int i = 0; i < movieArr.length; i++) {
                        ArrayList<Review> reviewlist = movieArr[i].getreviewlist();
                        double num = movieArr[i].getRating();
                        String word = "Nan";
                        if (num > 0 && reviewlist.size() > 1) {
                            System.out.println(i + " Movie " + movieArr[i].getTitle() + " current rating "
                                    + df.format(num) + " number of reviewer: " + reviewlist.size());
                        } else {
                            System.out.println(i + " Movie " + movieArr[i].getTitle() + " current rating " + "Nan"
                                    + " number of reviewer: " + reviewlist.size());
                        }

                    }
                    int choose = sc.nextInt();

                    System.out.println("Give a rating from 1-5");
                    int rating = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.println("Give a review");
                    String review = sc.nextLine();

                    Review rv = new Review(rating, review);
                    movieArr[choose].addReview(rv);
                    ArrayList<Review> reviewlist = movieArr[choose].getreviewlist();
                    movieArr[choose].addreviewscore(reviewlist);

                    System.out.println("Thank you for the review.");

                    break;
                default:
                    break;
            }

        } while (option != 8);

    }
}
