package MovieGoerModule;

import java.text.DecimalFormat;
import java.util.ArrayList;
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

        Movie[] movieArr = new Movie[7];
        movieArr[0] = new Movie("Batman");
        movieArr[1] = new Movie("Joker");
        movieArr[2] = new Movie("Superman");
        movieArr[3] = new Movie("Ironman");
        movieArr[4] = new Movie("Shazam");
        movieArr[5] = new Movie("Captain America");
        movieArr[6] = new Movie("Thor");

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

        int option = 0, choice = 0;
        do {
            System.out.println("Enter Option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Search/List movie");
                    Scanner s = new Scanner(System.in);
                    System.out.println("Search by keyword: ");
                    String key = s.nextLine();

                    for(int i=0; i<movieArr.length;i++){
                        if(movieArr[i].getTitle().toLowerCase().indexOf(key.toLowerCase()) > -1 ){
                            System.out.println(i+" Movie "+movieArr[i].getTitle() );
                        }
                    }

                    break;
                case 2:
                    System.out.println("2. View Movie details");
                    for(int i=0; i<movieArr.length;i++){
                        System.out.println(i+" Movie "+movieArr[i].getTitle() );
                    }
                    System.out.println("Select movie to view details");
                    choice = sc.nextInt();
                    System.out.println("Movie details : ");
                    System.out.println("Movie title: "+movieArr[choice].getTitle());
                    System.out.println("Movie status: "+movieArr[choice].getStatus());
                    System.out.println("Movie rating: "+movieArr[choice].getRating());
                    System.out.println("Movie Director: "+movieArr[choice].getDirector());
                    System.out.println("Movie synopsis: "+movieArr[choice].getSynopsis());

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
                    System.out.println("4. Book a ticket");

                    break;
                case 5:
                    System.out.println("5. View Booking History");

                    break;

                case 6:
                    System.out.println("6. List Top 5 Movies by sales OR by overall ratings");

                    //array for sorting
                    Movie[] top5m = movieArr;
                    System.out.println("1. by sales");
                    System.out.println("2. by rating");
                    choice = sc.nextInt();

                    switch(choice) {
                        case 1:
                            //Sort by sales only
                            break;
                        case 2:
                            //Sort by Rating only
                            Movie keys; int j;
                            for(int i=1; i<top5m.length;i++){
                                keys = top5m[i];
                                j=i-1;
                                while (j >= 0 &&  top5m[j].getrealrating() <  keys.getrealrating())
                                {
                                    top5m[j + 1] = top5m[j];
                                    j = j - 1;
                                }
                                top5m[j + 1] = keys;
                            }
                            break;
                    }
                    System.out.println("Here are the top 5 list: ");
                    int n=5;
                    if(top5m.length<5){ n=top5m.length;}
                    for(int i=0;i<n;i++){
                        System.out.println(i+" Movie: "+top5m[i].getTitle()+" Rating: "+top5m[i].getRating()+" Sales: "+top5m[i].getSales()+" Number of reviewer: "+top5m[i].getnumberofreviewer());
                    }
                    break;
                case 7:
                    System.out.println("7. Give a movie review");
                    System.out.println("List of all current movie with rating");
                    for(int i=0; i<movieArr.length;i++){
                        System.out.println(i+" Movie "+movieArr[i].getTitle()+" current rating "+ movieArr[i].getRating() +" number of reviewer: "+movieArr[i].getnumberofreviewer());
                    }
                    int choose = sc.nextInt();

                    System.out.println("Give a rating from 1-5");
                    int rating = sc.nextInt();
                    sc= new Scanner(System.in);
                    System.out.println("Give a review");
                    String review = sc.nextLine();

                    Review rv = new Review(rating,review);
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
