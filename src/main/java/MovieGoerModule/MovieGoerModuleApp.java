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

        Cineplex cathay = new Cineplex(3, "jcube");

        // TimeSlot newSlot = new TimeSlot("2022-02-20", 1700, 1800,
        // ClassOfCinama.PLATINUM);

        String Date1 = "2022-03-10";

        Movie movie1 = new Movie("Batman");
        Movie movie2 = new Movie("Joker");
        Movie movie3 = new Movie("Superman");

        movie1.addSlot(new TimeSlot("2022-10-31", "1500", "1700", ClassOfCinama.DOLBY));
        movie1.addSlot(new TimeSlot("2022-10-31", "1300", "1500", ClassOfCinama.DOLBY));
        movie1.addSlot(new TimeSlot("2022-11-02", "0900", "1100", ClassOfCinama.DOLBY));
        movie2.addSlot(new TimeSlot("2022-10-31", "1700", "1900", ClassOfCinama.DOLBY));
        movie2.addSlot(new TimeSlot("2022-11-01", "2000", "2200", ClassOfCinama.DOLBY));
        movie2.addSlot(new TimeSlot("2022-11-02", "0900", "1100", ClassOfCinama.DOLBY));
        movie3.addSlot(new TimeSlot("2022-10-31", "1700", "1900", ClassOfCinama.DOLBY));
        movie3.addSlot(new TimeSlot("2022-11-05", "2000", "2200", ClassOfCinama.DOLBY));
        movie3.addSlot(new TimeSlot("2022-11-06", "900", "1100", ClassOfCinama.DOLBY));

        Movie[] movieArr = new Movie[3];
        movieArr[0] = new Movie("Batman");
        movieArr[1] = new Movie("Joker");
        movieArr[2] = new Movie("Superman");

        cathay.addMovie(movie1);
        cathay.addMovie(movie2);
        cathay.addMovie(movie3);
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
                        System.out.println(i + " Movie " + cathay.getMovieList().get(i).getTitle());
                    }

                    break;
                case 2:
                    System.out.println("2. View Movie details");

                    break;
                case 3:
                    ArrayList<String> dateList = new ArrayList<String>(); // List of non-duplicated dates
                    ArrayList<TimeSlot> timeList;
                    int counter = 1;
                    System.out.println("3. Seat Availability and Booking");
                    System.out.println("Select Movie:");
                    for (int i = 0; i < cathay.getMovieList().size(); i++) {
                        System.out.println(i + " Movie " + cathay.getMovieList().get(i).getTitle());
                    }
                    int movieSelection = sc.nextInt();
                    if (cathay.getMovieList().get(movieSelection).getTimeSlots().size() == 0) {
                        System.out.println("No Available slots");
                        break;
                    } else {
                        System.out.println("Select Day");

                        timeList = cathay.getMovieList().get(movieSelection).getTimeSlots();

                        System.out.println("0 " + timeList.get(0).getStringDate());
                        dateList.add(timeList.get(0).getStringDate());
                        for (int j = 1; j < timeList.size(); j++) {

                            if (timeList.get(j).getStringDate() != timeList.get(j - 1).getStringDate()) {
                                System.out.println(counter + " " + timeList.get(j).getStringDate());
                                dateList.add(timeList.get(j).getStringDate());
                                counter++;
                            }
                        }
                    }
                    int daySelection = sc.nextInt();
                    System.out.println("Select Timeslot");
                    for (int j = 0; j < timeList.size(); j++) {

                        if (dateList.get(daySelection) == timeList.get(j).getStringDate()) {
                            System.out.println(j + " " + timeList.get(j).getStartTime() + "-"
                                    + timeList.get(j).getEndTime() + " " + timeList.get(j).getMovieClass());
                        }
                    }
                    int slotSelection = sc.nextInt();
                    System.out.println(Date1);
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
