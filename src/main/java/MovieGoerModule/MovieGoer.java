package MovieGoerModule;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieGoer extends Account{
    private String name;
    private double mobile;
    private String email;
    private ArrayList<Transaction> history;

    public MovieGoer(String username, String password) {
        super(username,password);
        super.setRole(Role.MOVIEGOER);
    }

    public MovieGoer(String username, String password, Role role, String name, double mobile, String email) {
        super(username,password);
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
