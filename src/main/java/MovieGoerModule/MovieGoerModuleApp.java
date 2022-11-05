package MovieGoerModule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MovieGoerModuleApp {
    public String[] holidays = { "01/01/2022", "01/02/2022", "02/02/2022", "15/04/2022", "01/05/2022", "03/05/2022",
            "15/05/2022", "10/07/2022", "09/08/2022", "24/10/2022", "25/12/2022" };

    public static void main(String[] args) throws Exception {
        // Initialisation
        Calendar today = Calendar.getInstance();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Cineplex cathay = new Cineplex(3);
        // TimeSlot newSlot = new TimeSlot("02/11/2022", 1700);

        String Date1 = "31/10/2022";

        Movie movie1 = new Movie("Batman");
        Movie movie2 = new Movie("Joker");
        Movie movie3 = new Movie("Superman");

        // Testing
        Movie[] movieArr = new Movie[7];
        movieArr[0] = new Movie("Batman");
        movieArr[1] = new Movie("Joker");
        movieArr[2] = new Movie("Superman");
        movieArr[3] = new Movie("Ironman");
        movieArr[4] = new Movie("Shazam");
        movieArr[5] = new Movie("Captain America");
        movieArr[6] = new Movie("Thor");

        movieArr[2].setAgetype(AgeOfMovieGoer.STUDENT);

        Cineplex[] cathay = new Cineplex[3];
        cathay[0] = new Cineplex(3, "cathay");
        cathay[1] = new Cineplex(3, "cathay woodland");
        cathay[2] = new Cineplex(3, "cathay boon lay");

        cathay[0].addSlot(new TimeSlot(Date1, "0", "2", ClassOfCinama.REGULAR, movieArr[0]));
        cathay[0].addSlot(new TimeSlot(Date1, "3", "5", ClassOfCinama.DOLBY, movieArr[1]));
        cathay[0].addSlot(new TimeSlot(Date1, "6", "8", ClassOfCinama.PLATINUM, movieArr[2]));
        cathay[0].addSlot(new TimeSlot(Date1, "8", "11", ClassOfCinama.PLATINUM, movieArr[0]));
        cathay[0].addSlot(new TimeSlot(Date1, "11", "13", ClassOfCinama.REGULAR, movieArr[3]));
        cathay[0].addSlot(new TimeSlot(Date1, "14", "16", ClassOfCinama.REGULAR, movieArr[4]));

        MovieGoer man = new MovieGoer("Derrick", "p");
        man.setAge(19);

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

        int option = 0, cinema = 0, choice = 0, Qty = 0;
        float time;
        String key, datetime, movie;
        Cineplex cinename;
        TimeSlot ts;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Enter Option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Search/List movie");
                    System.out.println("Search by keyword: ");
                    key = s.nextLine();
                    for (int i = 0; i < movieArr.length; i++) {
                        if (movieArr[i].getTitle().toLowerCase().indexOf(key.toLowerCase()) > -1) {
                            System.out.println(i + " Movie " + movieArr[i].getTitle());
                        }
                    }

                    break;
                case 2:
                    System.out.println("2. View Movie details");
                    for (int i = 0; i < movieArr.length; i++) {
                        System.out.println(i + " Movie " + movieArr[i].getTitle());
                    }
                    System.out.println("Select movie to view details");
                    choice = sc.nextInt();
                    System.out.println("Movie details : ");
                    System.out.println("Movie title: " + movieArr[choice].getTitle());
                    System.out.println("Movie status: " + movieArr[choice].getStatus());
                    System.out.println("Movie rating: " + movieArr[choice].getRating());
                    System.out.println("Movie Director: " + movieArr[choice].getDirector());
                    System.out.println("Movie synopsis: " + movieArr[choice].getSynopsis());

                    break;

                case 3:
                    ArrayList<String> dateList = new ArrayList<String>();
                    ArrayList<TimeSlot> slotList = new ArrayList<TimeSlot>();
                    ArrayList<TimeSlot> slotList2 = new ArrayList<TimeSlot>();
                    String dateSelection = "";
                    TimeSlot slotSelected;

                    System.out.println("3. Seat Availability and Booking");
                    System.out.println("Enter which cineplex: ");
                    for (int i = 0; i < cathay.length; i++) {
                        System.out.println(i + " Cinema: " + cathay[i].getName());
                    }
                    cinema = sc.nextInt();
                    cinename = cathay[cinema];
                    if (cinename.getTimeslots().size() == 0) {
                        System.out.println("No Movie is airing in this cineplex");
                        break;
                    }

                    cinename.getMovieList();
                    System.out.println("Which movie :");

                    for (int i = 0; i < cinename.getMovieList().size(); i++) {
                        System.out.println(cinename.getMovieList().get(i).getTitle());
                    }
                    int movieSelection = sc.nextInt();
                    slotList = cinename.getMovieList().get(movieSelection).getTimeSlots();

                    if (slotList.size() == 0) {
                        System.out.println("No date Available");
                    } else {
                        String firstDate = slotList.get(0).getStringDate();
                        System.out.println(0 + " " + slotList.get(0).getStringDate());

                        for (int i = 1; i < slotList.size(); i++) {
                            if (slotList.get(i - 1).getStringDate() != slotList.get(i).getStringDate()) {
                                dateList.add(slotList.get(i).getStringDate());
                                System.out.println(slotList.get(i).getStringDate());
                            }
                        }

                        System.out.println("Select a date");
                        for (int i = 0; i < dateList.size(); i++) {
                            System.out.println(i + ". " + dateList.get(i));
                        }
                        int input = sc.nextInt();
                        dateSelection = dateList.get(input);
                    }

                    System.out.println("Select Timeslot");
                    for (int i = 0; i < slotList.size(); i++) {
                        if (slotList.get(i).getStringDate() == dateSelection) {
                            slotList2.add(slotList.get(i));
                            System.out.print(
                                    i + " " + slotList.get(i).getStartTime() + "-" + slotList.get(i).getEndTime());
                        }
                    }
                    int inputSlot = sc.nextInt();
                    slotSelected = slotList2.get(inputSlot);
                    slotSelected.getRoom().printSeats();

                    break;
                case 4:
                    System.out.println("4. Book a ticket");
                    System.out.println("Select Cineplex");
                    System.out.println("Enter which cineplex: ");
                    for (int i = 0; i < cathay.length; i++) {
                        System.out.println(i + " Cinema: " + cathay[i].getName());
                    }
                    cinema = sc.nextInt();
                    cinename = cathay[cinema];
                    if (cinename.getTimeslots().size() == 0) {
                        System.out.println("No Movie is airing in this cineplex");
                        break;
                    }

                    System.out.println("Input date (DD/MM/YYYY) :");
                    datetime = s.nextLine();

                    System.out.println("Select the cineplex movie timeslot");
                    for (int i = 0; i < cinename.getTimeslots().size(); i++) {
                        ts = cinename.getTimeslots().get(i);
                        if (datetime.equals(ts.getStringDate())) {
                            System.out.println(i + " Airing movie :" + ts.getAiringmovie().getTitle() + " time:"
                                    + ts.getairingtimeformat() + " type:" + ts.getMovieClass());
                        }
                    }
                    choice = sc.nextInt();
                    ts = cinename.getTimeslots().get(choice);

                    // Age category check
                    if (choice >= cinename.getTimeslots().size()) {
                        System.out.println("Please Choose appropriate timeslot!");
                        break;
                    }

                    if (man.getAgetype().ordinal() <= ts.getAiringmovie().getAge_restriction().ordinal()) {
                        System.out.println("You don't meet the age requirement to watch "
                                + ts.getAiringmovie().getAge_restriction() + " Movie");
                        break;
                    }

                    System.out.println("Select Qty: ");
                    Qty = sc.nextInt();
                    LocalDate dt = LocalDate.parse(datetime, df);
                    Day d;
                    if (dt.getDayOfWeek() == DayOfWeek.MONDAY || dt.getDayOfWeek() == DayOfWeek.TUESDAY
                            || dt.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        d = Day.MON_TO_WED;
                    } else if (dt.getDayOfWeek() == DayOfWeek.THURSDAY) {
                        d = Day.THURS;
                    } else if (dt.getDayOfWeek() == DayOfWeek.FRIDAY || dt.getDayOfWeek() == DayOfWeek.SATURDAY
                            || dt.getDayOfWeek() == DayOfWeek.SUNDAY) {
                        d = Day.FRI_BEFORE_6;
                    } else {
                        d = Day.REMAINING_DAYS;
                    }

                    System.out.println("Select Seats: (Example: A12, B9)");
                    ts.getRoom().printSeats();
                    for (int q = 0; q < Qty; q++) {
                        String selectseat = s.nextLine();
                        // System.out.println( Integer.valueOf(
                        // selectseat.toLowerCase().substring(0,1).charAt(0)-96) +" "+
                        // Integer.parseInt(selectseat.substring(1)));
                        int row = Integer.valueOf(selectseat.toLowerCase().substring(0, 1).charAt(0) - 96) - 1;
                        int col = Integer.parseInt(selectseat.substring(1)) - 1;
                        if (!ts.getRoom().checkseat(row, col)) {
                            ts.getRoom().book(row, col);
                        } else {
                            System.out.println("Sorry the seat is taken. Choose again!");
                            q = q - 1;
                        }
                    }
                    Ticket[] t = new Ticket[1];
                    t[0] = new Ticket(Qty, man.getAgetype(), ts.getAiringmovie().getType(), ts.getMovieClass(), d);
                    Transaction trans = new Transaction("id?", t);
                    man.getTransactionHistory().add(trans);

                    System.out.println(Qty + " Booking places");
                    break;
                case 5:
                    System.out.println("5. View Booking History");

                    break;

                case 6:
                    System.out.println("6. List Top 5 Movies by sales OR by overall ratings");

                    // array for sorting
                    Movie[] top5m = movieArr;
                    System.out.println("1. by sales");
                    System.out.println("2. by rating");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            // Sort by sales only
                            break;
                        case 2:
                            // Sort by Rating only
                            Movie keys;
                            int j;
                            for (int i = 1; i < top5m.length; i++) {
                                keys = top5m[i];
                                j = i - 1;
                                while (j >= 0 && top5m[j].getrealrating() < keys.getrealrating()) {
                                    top5m[j + 1] = top5m[j];
                                    j = j - 1;
                                }
                                top5m[j + 1] = keys;
                            }
                            break;
                    }
                    System.out.println("Here are the top 5 list: ");
                    int n = 5;
                    if (top5m.length < 5) {
                        n = top5m.length;
                    }
                    for (int i = 0; i < n; i++) {
                        System.out.println(i + " Movie: " + top5m[i].getTitle() + " Rating: " + top5m[i].getRating()
                                + " Sales: " + top5m[i].getSales() + " Number of reviewer: "
                                + top5m[i].getnumberofreviewer());
                    }
                    break;
                case 7:
                    System.out.println("7. Give a movie review");
                    System.out.println("List of all current movie with rating");
                    for (int i = 0; i < movieArr.length; i++) {
                        System.out.println(
                                i + " Movie " + movieArr[i].getTitle() + " current rating " + movieArr[i].getRating()
                                        + " number of reviewer: " + movieArr[i].getnumberofreviewer());
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
                    movieArr[choose].updatereviewscore(reviewlist);

                    System.out.println("Thank you for the review.");

                    break;
                default:
                    break;
            }

        } while (option != 8);

    }
}
