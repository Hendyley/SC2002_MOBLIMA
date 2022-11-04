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
    private TypeOfMovie type;
    private ArrayList<Review> allreviews = new ArrayList<>();
    private ArrayList<TimeSlot> timeslots = new ArrayList<>();

    public Movie(String title ) {
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
    
    public void setType(TypeOfMovie type){
        this.type = type;
    }

    public double getSales(){ return sales;}

    public ArrayList<Review> getreviewlist(){
        return allreviews;
    }

    public double addreviewscore(ArrayList<Review> allreviews){
        int rate=0;
        for(int i=0;i<allreviews.size();i++){
            rate = rate + allreviews.get(i).getUserRating();
        }
        rating = (float) rate / allreviews.size();
        return rating;
    }

    public double getRating(){
        return rating;
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
        for (int i = 0; i < cast.size()-1; i++){
            System.out.print(cast.get(i) + ", ");
        }
        System.out.println(cast.get(cast.size()-1));
        System.out.println("Rating: " + rating);
    }
}
