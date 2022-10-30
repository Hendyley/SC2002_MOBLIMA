package MovieGoerModule;

import java.util.ArrayList;

public class MovieGoer {
    private String name;
    private double mobile;
    private String email;
    private ArrayList<Transaction> history;

    public MovieGoer() {

    }

    public MovieGoer(String name, double mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(double mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
