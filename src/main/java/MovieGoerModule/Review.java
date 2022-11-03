package MovieGoerModule;

public class Review {
    private int userRating;
    private String remark;

    public Review(int rating, String rv){
        this.userRating = rating;
        this.remark = rv;
    }

    public int getUserRating(){
        return userRating;
    }

    public void setRating(int rating) {
        this.userRating = rating;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



}
