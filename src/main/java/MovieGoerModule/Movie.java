package MovieGoerModule;

import java.util.ArrayList;

public class Movie {
    private String title;
    private Status status = Status.NOW_SHOWING;
    private String synopsis = "NA";
    private String director = "NA";
    private ArrayList<String> cast;
    private double sales;
    private float rating = -1;
    private ArrayList<Review> allreviews;
    private ArrayList<TimeSlot> timeslots;

    public Movie(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(Status stat) {
        this.status = stat;
    }

    public void setSynopsis(String synop) {
        this.synopsis = synop;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void addCast(String name) {
        cast.add(name);
    }

    public void clearCast() {
        cast.clear();
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void addReview(Review review) {
        allreviews.add(review);
    }

    public void addSlot(TimeSlot slot) {
        for (int i = 0; i < timeslots.size(); i++) {
            // if (slot.getStringDate().compareTo(director))
        }

        timeslots.add(slot);
    }

    public String getTitle() {
        return title;
    }

    public void incrementSales(double sale) {
        this.sales += sale;
    }

    public void printDetails() {
        System.out.println("Movie title: " + title);
        System.out.println("Status: " + status);
        System.out.println("Synopsis: " + synopsis);
        System.out.println("Director: " + director);
        System.out.println("Cast: ");
        System.out.println("Rating: " + rating);
    }
}
