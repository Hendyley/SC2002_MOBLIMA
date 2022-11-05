package MovieGoerModule;

import java.util.ArrayList;

public class MovieGoer extends Account{
    private String name;

    private int age; //see how
    private AgeOfMovieGoer agetype;

    private int mobile;
    private String email;
    private ArrayList<Transaction> history;


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
        //CHILD, ADULT, SENIOR, STUDENT
        this.age = age;
        if(age>50){
            agetype = AgeOfMovieGoer.SENIOR;
        } else if (age>20) {
            agetype = AgeOfMovieGoer.ADULT;
        } else if (age>10) {
            agetype = AgeOfMovieGoer.STUDENT;
        } else {
            agetype = AgeOfMovieGoer.CHILD;
        }
    }
    public int getAge(){return age;}


    public AgeOfMovieGoer getAgetype() {
        return agetype;
    }

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
