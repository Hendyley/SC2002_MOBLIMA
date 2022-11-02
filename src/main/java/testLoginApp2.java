import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import MovieGoerModule.Movie;
import MovieGoerModule.MovieGoer;
import MovieGoerModule.Role;
import AdminModule.Staff;

public class testLoginApp2 {
    private final static String ACCOUNT_FILE_NAME = "AccountList2.txt";
    private static Scanner sc = new Scanner(System.in);
    private static Role currentRole;
    private static boolean isLogined = false;
    public static void main(String[] args) throws ClassNotFoundException, IOException{
        
        int loginOption;
        
        generateDummyData();
        printAccountLists();
        do{
            System.out.println("    testLoginApp    ");
            System.out.println("********************");
            System.out.println("1. Login into Account");
            System.out.println("2. Continue as guest");
            System.out.println("3. Exit");
            System.out.println("********************");
            loginOption = sc.nextInt();
            sc.nextLine();

            switch(loginOption){
                case 1:
                    switch_case_login();
                    break;
                case 2:
                    switch_case_guest();
                    break;
                default:
                    break;
            } 
        }while(loginOption != 3);

        sc.close();
    }

    public static ArrayList<Object> getAccountListsFromFile() throws IOException, ClassNotFoundException {
        ArrayList<Object> accountLists = new ArrayList<Object>();
        ArrayList<Object> staffList = new ArrayList<Object>();
        ArrayList<Object> mgList = new ArrayList<Object>();;
        accountLists.add(staffList);
        accountLists.add(mgList);
               
        try {
            FileInputStream fileInputStream2 = new FileInputStream(ACCOUNT_FILE_NAME);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            accountLists = (ArrayList<Object>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Account Lists retrieved from File");

        } catch (FileNotFoundException e) {
            FileOutputStream fileOutputStream = new FileOutputStream(ACCOUNT_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountLists);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Account List File not found, creating new Account List File");
        }

        return accountLists;
    }

    public static void addAccountListsToFile(ArrayList<Object> accountLists) throws IOException {
            FileOutputStream fileOutputStream = new FileOutputStream(ACCOUNT_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountLists);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.printf("Account Lists added to File\n");
    }

    public static boolean isUsernameExist(ArrayList<Object> accountLists,String username){
        ArrayList<Staff> staffList = (ArrayList<Staff>)accountLists.get(0);
        ArrayList<MovieGoer> mgList = (ArrayList<MovieGoer>)accountLists.get(1);

        for (Staff s : staffList) {
            if (s.getUsername().equals(username)) {
                return true;
            }
        }

        for (MovieGoer mg : mgList) {
            if (mg.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }


    private static void generateDummyData() throws ClassNotFoundException, IOException{
        ArrayList<Object> accountLists = getAccountListsFromFile();
        ArrayList<Staff> staffList = (ArrayList<Staff>)accountLists.get(0);
        ArrayList<MovieGoer> mgList = (ArrayList<MovieGoer>)accountLists.get(1);
        Staff staff1;
        MovieGoer mg1;

        
        staff1 = new Staff("admin", "admin123");
        if(!isUsernameExist(accountLists, staff1.getUsername())){
            staffList.add(staff1);
        }

        if(!isUsernameExist(accountLists, staff1.getUsername())){
            mg1 = new MovieGoer("user1", "user123");
            mgList.add(mg1);
        }

        if(!isUsernameExist(accountLists, staff1.getUsername())){
            mg1 = new MovieGoer("user2","user234");
            mgList.add(mg1);
        }

        accountLists.set(0,staffList); 
        accountLists.set(1,mgList);
        addAccountListsToFile(accountLists);
    }

    private static void printAccountLists() throws ClassNotFoundException, IOException{
        ArrayList<Object> accountLists = getAccountListsFromFile();
        ArrayList<Staff> staffList = (ArrayList<Staff>)accountLists.get(0);
        ArrayList<MovieGoer> mgList = (ArrayList<MovieGoer>)accountLists.get(1);

        System.out.println("Printing out Staff List");
        for(Staff s : staffList){
            System.out.printf("username: %s ,password: %s ,role: %s\n",s.getUsername(),s.getPassword(),s.getRole());
        }
        System.out.println("");
        System.out.println("Printing out MovieGoer List");
        for(MovieGoer mg : mgList){
            System.out.printf("username: %s ,password: %s ,role: %s\n",mg.getUsername(),mg.getPassword(),mg.getRole());
            System.out.printf("name: %s ,email: %s ,mobile: %s\n",mg.getName(),mg.getEmail(),mg.getMobile());
            System.out.printf("Transaction List: %s \n",mg.getTransactionHistory());
        }
        
    }

    public static boolean login(ArrayList<Object> accountLists, String username, String password) {
        ArrayList<Staff> staffList = (ArrayList<Staff>)accountLists.get(0);
        ArrayList<MovieGoer> mgList = (ArrayList<MovieGoer>)accountLists.get(1);

        for (Staff s : staffList) {
            if (s.getUsername().equals(username)
                    && s.getPassword().equals(password)) {
                System.out.println("Login Success");
                System.out.println();
                currentRole = Role.ADMIN;
                isLogined = true;
                return true;
            }
        }

        for (MovieGoer mg : mgList) {
            if (mg.getUsername().equals(username)
                    && mg.getPassword().equals(password)) {
                System.out.println("Login Success");
                System.out.println();
                currentRole = Role.MOVIEGOER;
                isLogined = true;
                return true;
            }
        }
        

        System.out.println("Incorrect Username or Password");
        System.out.println();
        return false;
    }


    public static void switch_case_login() throws ClassNotFoundException, IOException{
        String username;
        String password;

        System.out.println("Login");
        System.out.print("Username:");
        username = sc.nextLine();
        System.out.print("Password:");
        password = sc.nextLine();
        ArrayList<Object> accountLists = getAccountListsFromFile();

        if(!login(accountLists,username,password)){
            return;
        }

        if(currentRole == Role.ADMIN){
            switch_case_admin();
        }else{
            switch_case_moviegoer();
        }

    }

    private static void switch_case_guest(){
        System.out.println("switch_case_guest");
    }

    private static void switch_case_admin(){
        System.out.println("switch_case_admin");
    }

    private static void switch_case_moviegoer(){
        System.out.println("switch_case_moviegoer");
    }


}
