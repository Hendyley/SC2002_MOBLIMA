package MovieGoerModuleApp;

import java.util.ArrayList;

public class Movie {
    private String title;
    private Status status;
    private String synopsis;
    private String director;
    private ArrayList<String> cast;
    private float rating;
    private ArrayList<Review> allreviews;

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
}
