import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import MovieGoerModule.Cineplex;
import MovieGoerModule.Movie;
import MovieGoerModule.MovieGoer;
import MovieGoerModule.Review;
import MovieGoerModule.Role;
import MovieGoerModule.TimeSlot;
import AdminModule.Staff;
import AdminModule.cineplexDB;

public class MoblimaApp {
    private final static String ACCOUNT_FILE_NAME = "AccountList.txt";
    private final static String CINEPLEX_FILE_NAME = "Cineplex.txt";
    private final static String PRICELIST_FILE_NAME = "Pricelist.txt";
    private static Scanner sc = new Scanner(System.in);
    private static Role currentRole;
    private static boolean isLogined = false;
    private static boolean isGuest = false;
    public String[] holidays = { "01/01/2022", "01/02/2022", "02/02/2022", "15/04/2022", "01/05/2022", "03/05/2022",
    "15/05/2022", "10/07/2022", "09/08/2022", "24/10/2022", "25/12/2022" };
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
                    isGuest = true;
                    switch_case_moviegoer();
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

        mg1 = new MovieGoer("user1", "user123", "Adams",95463461,"adamsOKorNot@gmail.com");
        mg1.setAge(19);
        if(!isUsernameExist(accountLists, mg1.getUsername())){            
            mgList.add(mg1);
        }

        mg1 = new MovieGoer("user2","user234","John",94352423,"johnIsOk@gmail.com");
        mg1.setAge(31);
        if(!isUsernameExist(accountLists, mg1.getUsername())){
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


    private static void switch_case_admin(){
        System.out.println("switch_case_admin");
    }

    private static void switch_case_moviegoer() throws ClassNotFoundException, IOException{
        ArrayList<Cineplex> cathay = cineplexDB.getCineplexListFromFile();
        Scanner sc = new Scanner(System.in);



        int option = 0, cinema = 0, choice = 0, Qty = 0;
        float time;
        String key, datetime, movie, seatdesc;
        Cineplex cinename;
        ArrayList<Movie> movieList;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("********************");
            System.out.println("Movie Goer Module");
            System.out.println("1. Search/List movie");
            System.out.println("2. View Movie details");
            System.out.println("3. Seat Availability and Booking");
            System.out.println("4. Book a ticket");
            System.out.println("5. View Booking History");
            System.out.println("6. List Top 5 Movies by sales OR by overall ratings");
    
            System.out.println("7. Give a movie review");
            if(isLogined){
                System.out.println("8. Log out");
            }else{
                System.out.println("8. End Guest Session");
            }
            System.out.println("********************");

            System.out.println("Enter Option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Search/List movie");
                   
                    movieList = getMovieList(cathay,sc);
                    do {
                        boolean isNotFound = true;
                        System.out.println("1. Search movie");
                        System.out.println("2. List movie");
                        System.out.println("3. Exit");
                        System.out.println("Enter a choice");
                        choice = sc.nextInt();
                         //clear buffer
                         sc.nextLine();

                        switch (choice) {
                            case 1:
                                System.out.println("Search by keyword: ");
                                key = s.nextLine();
                                System.out.println("Movie search results:");
                                for (int j = 0; j < movieList.size(); j++) {
                                    if (movieList.get(j).getTitle().toLowerCase().indexOf(key.toLowerCase()) != -1) {
                                        System.out.println(j + ". " + movieList.get(j).getTitle());
                                        isNotFound = false;
                                    }
                                }
                                break;
                            
                            case 2:
                                System.out.println("Movie lists:");
                                for (int j = 0; j < movieList.size(); j++) {
                                    System.out.println(j + ". " + movieList.get(j).getTitle());
                                    isNotFound = false;
                                }
                                break;
                            case 3:
                                System.out.println("Exiting Search/List movie...");
                                break;

                            default:
                                break;
                        }
                        
                        if(isNotFound  && (choice == 1 || choice == 2)){
                            System.out.println("No result found");
                        }
                        System.out.println("");                        
                    } while (choice != 3);

                    break;
                case 2:
                    System.out.println("2. View Movie details");
                    
                    movieList = getMovieList(cathay,sc);
                    if(movieList.size() < 1){
                        System.out.println("No movie available.");
                        break;
                    }

                    for (int i = 0; i < movieList.size(); i++) {
                        System.out.println(i + " Movie " + movieList.get(i).getTitle()+" "+ movieList.get(i).getStatus()+" "
                            +movieList.get(i).getType()+" "+movieList.get(i).getAge_restriction());
                    }
                    System.out.println("Select movie to view details");
                    choice = sc.nextInt();
                    if(choice>=movieList.size()){
                        System.out.println("Please Choose appropriate Movie!");
                        break;
                    }
                    System.out.println("Movie Details : ");
                    System.out.println("Movie Title: " + movieList.get(choice).getTitle());
                    System.out.println("Movie Status: " + movieList.get(choice).getStatus());
                    System.out.println("Movie Duration: "+ movieList.get(choice).getMovieDurationMin()+ " minutes");
                    System.out.println("Movie Age Requirement: "+ movieList.get(choice).getAge_restriction());
                    System.out.println("Movie Type: "+ movieList.get(choice).getType());
                    // System.out.println("Movie Rating: " + movieList.get(choice).getRating());
                    System.out.println("Movie Director: " + movieList.get(choice).getDirector());
                    System.out.println("Movie Synopsis: " + movieList.get(choice).getSynopsis());
                    System.out.println("Movie Airing time: ");
                    ArrayList<TimeSlot> showair = movieList.get(choice).getTimeSlots();
                    for(int i=0; i<showair.size(); i++){
                        System.out.println(showair.get(i).getairingtimeformat()+" "+showair.get(i).getRoom().getCinemaClass());
                    }
                    // System.out.println("Movie Review: ");
                    // ArrayList<Review> showreview = movieList.get(choice).getreviewlist();
                    // for(int i=0; i<showreview.size(); i++){
                    //     System.out.println("Comment: "+i+" "+showreview.get(i).getRemark());
                    // }
                    System.out.println("");
                    break;

                case 3:
                    ArrayList<String> dateList = new ArrayList<String>();
                    ArrayList<TimeSlot> slotList = new ArrayList<TimeSlot>();
                    ArrayList<TimeSlot> slotList2 = new ArrayList<TimeSlot>();
                    String dateSelection = "";
                    TimeSlot slotSelected;

                    System.out.println("3. Seat Availability and Booking");
                    System.out.println("Cineplex List:");
                    for (int i = 0; i < cathay.size(); i++) {
                        System.out.println(i + ". " + cathay.get(i).getName());
                    }
                    System.out.println("Select one of the cineplex index");
                    cinema = sc.nextInt();
                    if (cinema >= cathay.size()) {
                        System.out.println("Please Choose appropriate Cinema!");
                        break;
                    }
                    cinename = cathay.get(cinema);
                    // if (cinename.getTimeslots().size() == 0) {
                    // System.out.println("No Movie is airing in this cineplex");
                    // break;
                    // }
                    if(cinename.getMovieList().size() < 1){
                        System.out.println("No movie available");
                        break;
                    }
                    System.out.println("Which movie :");

                    for (int i = 0; i < cinename.getMovieList().size(); i++) {
                        System.out.println(i + " " + cinename.getMovieList().get(i).getTitle());
                    }
                    int movieSelection = sc.nextInt();
                    if (movieSelection >= cinename.getMovieList().size()) {
                        System.out.println("Please Choose appropriate Movie!");
                        break;
                    }
                    slotList = cinename.getMovieList().get(movieSelection).getTimeSlots();

                    if (slotList.size() == 0) {
                        System.out.println("No date Available");
                    } else {
                        System.out.println("Select a date");
                        String firstDate = slotList.get(0).getStringDate();
                        System.out.println(0 + " " + slotList.get(0).getStringDate());
                        dateList.add(firstDate);
                        for (int i = 1; i < slotList.size(); i++) {
                            if (slotList.get(i - 1).getStringDate() != slotList.get(i).getStringDate()) {
                                dateList.add(slotList.get(i).getStringDate());
                                System.out.println(i + " " + slotList.get(i).getStringDate());
                            }
                        }

                        int input = sc.nextInt();
                        if (input >= dateList.size()) {
                            System.out.println("Please Choose appropriate Date!");
                            break;
                        }
                        dateSelection = dateList.get(input);
                    }

                    System.out.println("Select Timeslot");
                    for (int i = 0; i < slotList.size(); i++) {
                        if (slotList.get(i).getStringDate() == dateSelection) {
                            slotList2.add(slotList.get(i));
                        }
                    }
                    for (int i = 0; i < slotList2.size(); i++) {
                        System.out.println(
                                i + " " + slotList2.get(i).getStartTime() + "-" +
                                        slotList2.get(i).getEndTime());
                    }

                    int inputSlot = sc.nextInt();
                    if (inputSlot >= slotList2.size()) {
                        System.out.println("Please Choose appropriate TimeSlot!");
                        break;
                    }
                    slotSelected = slotList2.get(inputSlot);
                    slotSelected.getRoom().printSeats();

                    seatdesc = slotSelected.getRoom().getseattypedesc();
                    String couples = seatdesc.substring(0,seatdesc.indexOf("Elite"));
                    String elite = seatdesc.substring(seatdesc.indexOf("Elite"),seatdesc.indexOf("Ulti"));
                    String ulti = seatdesc.substring(seatdesc.indexOf("Ulti"));
                    System.out.println(couples);
                    System.out.println(elite);
                    System.out.println(ulti);

                    break;
                case 8:
                    if(isLogined){
                        isLogined = false;
                        System.out.println("Logged Out Successfully!");
                    }

                    if(isGuest){
                        isGuest = false;
                        System.out.println("Guest Session Ended");
                    }
                    break;
                    
                default:
                    break;
            }

        } while (isLogined || isGuest);

    }


    private static ArrayList<Movie> getMovieList(ArrayList<Cineplex> cathay, Scanner sc){
        int i = 0;
        int index = -1;
        ArrayList<Movie> movieList;

        System.out.println("Cineplex List:");
        for(Cineplex cineplex :cathay){
            System.out.printf("%s. %s\n",i,cineplex.getName());
            i++;
        }
        
        do {
            System.out.println("Select one of the cineplex index");
            index = sc.nextInt();
        } while (index < 0 || index > cathay.size()-1);
       

       return movieList = cathay.get(index).getMovieList();
    }


}
