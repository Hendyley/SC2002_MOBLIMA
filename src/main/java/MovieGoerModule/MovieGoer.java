package MovieGoerModule;

import java.util.ArrayList;

public class MovieGoer extends Account{
    private String name;

    private int age; //see how
    private int mobile;
    private String email;
    private ArrayList<Transaction> history;

    private ArrayList<Ticket> ticket;

    public MovieGoer(String username, String password) {
        super(username,password);
        super.setRole(Role.MOVIEGOER);
        this.name = "";
        this.email = "";
        this.mobile = -1;
        this.history = new ArrayList<>();
    }

    public MovieGoer(String username, String password, Role role, String name, int mobile, String email) {
        super(username,password);
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.history = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getMobile() {
        return this.mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){return age;}

    public ArrayList<Transaction> getTransactionHistory(){
        return this.history;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
