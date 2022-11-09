package MovieGoerModule;

import AdminModule.Holiday;
import AdminModule.cineplexDB;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static AdminModule.configureSettings.getPricelistFromFile;


public class MovieGoerModuleApp{

    private final static String PRICELIST_FILE_NAME = "Pricelist.txt";
    public static void main(String[] args) throws Exception {
        // Initialisation
        Calendar today = Calendar.getInstance();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        //System.out.println(dtf.format(now));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] holidays = { "01/01/2022", "01/02/2022", "02/02/2022", "15/04/2022", "01/05/2022", "03/05/2022",
                "15/05/2022", "10/07/2022", "09/08/2022", "24/10/2022", "25/12/2022" };


        ArrayList<Cineplex> cathay = cineplexDB.getCineplexListFromFile();

        // Cineplex cathay = new Cineplex(3);
        // TimeSlot newSlot = new TimeSlot("02/11/2022", 1700);

        // String Date1 = "31/10/2022";

        // Movie movie1 = new Movie("Batman");
        // Movie movie2 = new Movie("Joker");
        // Movie movie3 = new Movie("Superman");

        // // Testing
        // Movie[] movieArr = new Movie[7];
        // movieArr[0] = new Movie("Batman");
        // movieArr[1] = new Movie("Joker");
        // movieArr[2] = new Movie("Superman");
        // movieArr[3] = new Movie("Ironman");
        // movieArr[4] = new Movie("Shazam");
        // movieArr[5] = new Movie("Captain America");
        // movieArr[6] = new Movie("Thor");

        // movieArr[2].setAgetype(AgeOfMovieGoer.STUDENT);
        // movieArr[4].setAgetype(AgeOfMovieGoer.CHILD);

        // Cineplex[] cathay = new Cineplex[3];
        // cathay[0] = new Cineplex(3, "cathay");
        // cathay[1] = new Cineplex(3, "cathay woodland");
        // cathay[2] = new Cineplex(3, "cathay boon lay");

        // Cinema roomstyle = new Cinema();
        // roomstyle.setseattype(9,0,Seattype.COUPLE_SEAT);
        // roomstyle.setseattype(9,2,Seattype.COUPLE_SEAT);
        // roomstyle.setseattype(9,4,Seattype.COUPLE_SEAT);
        // roomstyle.setseattype(9,6,Seattype.COUPLE_SEAT);

        // roomstyle.setseattype(8,0,Seattype.ELITE_SEAT);
        // roomstyle.setseattype(8,2,Seattype.ELITE_SEAT);

        // roomstyle.setseattype(8,4,Seattype.ULTIMA_SEAT);
        // roomstyle.setseattype(8,6,Seattype.ULTIMA_SEAT);

        // cathay[0].addSlot(new TimeSlot(Date1, "0", "2", ClassOfCinama.REGULAR,
        // movieArr[0], roomstyle));
        // cathay[0].addSlot(new TimeSlot(Date1, "3", "5", ClassOfCinama.DOLBY,
        // movieArr[1], roomstyle));
        // cathay[0].addSlot(new TimeSlot(Date1, "6", "8", ClassOfCinama.PLATINUM,
        // movieArr[2], roomstyle));
        // cathay[0].addSlot(new TimeSlot(Date1, "8", "11", ClassOfCinama.PLATINUM,
        // movieArr[0], roomstyle));
        // cathay[0].addSlot(new TimeSlot(Date1, "11", "13", ClassOfCinama.REGULAR,
        // movieArr[3], roomstyle));
        // cathay[0].addSlot(new TimeSlot(Date1, "14", "16", ClassOfCinama.REGULAR,
        // movieArr[4], roomstyle));

        // movieArr[0].addSlot(new TimeSlot("01/01/2022", "1500", "1700", ClassOfCinema.DOLBY, roomstyle));
        // movieArr[0].addSlot(new TimeSlot("01/02/2022", "1300", "1500", ClassOfCinema.DOLBY, roomstyle));
        // movieArr[0].addSlot(new TimeSlot("01/03/2022", "0900", "1100", ClassOfCinema.DOLBY, roomstyle));

        // movieArr[1].addSlot(new TimeSlot("01/05/2022", "1500", "1700", ClassOfCinema.DOLBY, roomstyle));
        // movieArr[1].addSlot(new TimeSlot("01/06/2022", "1300", "1500", ClassOfCinema.DOLBY, roomstyle));
        // movieArr[1].addSlot(new TimeSlot("01/07/2022", "0900", "1100", ClassOfCinema.DOLBY, roomstyle));

        // movieArr[2].addSlot(new TimeSlot("01/08/2022", "1500", "1700", ClassOfCinema.DOLBY, roomstyle));
        // movieArr[2].addSlot(new TimeSlot("01/09/2022", "1300", "1500", ClassOfCinema.DOLBY, roomstyle));
        // movieArr[2].addSlot(new TimeSlot("01/10/2022", "0900", "1100", ClassOfCinema.DOLBY, roomstyle));
        // movieArr[4].addSlot(new TimeSlot("09/08/2022", "0900", "1100", ClassOfCinema.PLATINUM, roomstyle));

        // cathay[0].getMovieList().add(movieArr[0]);
        // cathay[0].getMovieList().add(movieArr[1]);
        // cathay[0].getMovieList().add(movieArr[2]);
        // cathay[0].getMovieList().add(movieArr[4]);

        // cathay[1].getMovieList().add(movieArr[0]);
        // cathay[1].getMovieList().add(movieArr[1]);

        // cathay[2].getMovieList().add(movieArr[1]);
        // cathay[2].getMovieList().add(movieArr[2]);

        MovieGoer man = new MovieGoer("Derrick", "p");
        man.setAge(21);

        // *************************
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
            System.out.println("8. Exit");
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
                    System.out.println("Movie Rating: " + movieList.get(choice).getRating());
                    System.out.println("Movie Director: " + movieList.get(choice).getDirector());
                    System.out.println("Movie Synopsis: " + movieList.get(choice).getSynopsis());
                    System.out.println("Movie Airing time: ");
                    ArrayList<TimeSlot> showair = movieList.get(choice).getTimeSlots();
                    for(int i=0; i<showair.size(); i++){
                        System.out.println(showair.get(i).getairingtimeformat()+" "+showair.get(i).getRoom().getCinemaClass());
                    }
                    System.out.println("Movie Review: ");
                    ArrayList<Review> showreview = movieList.get(choice).getreviewlist();
                    for(int i=0; i<showreview.size(); i++){
                        System.out.println("Comment: "+i+" "+showreview.get(i).getRemark());
                    }
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
                case 4:
                    LocalDateTime now = LocalDateTime.now();
                    ArrayList<TimeSlot> ts1 = null;
                    ArrayList<String> datel = new ArrayList<String>();
                    String dateS = "";
                    TimeSlot tss = null;
                    Cineplex cine = null;
                    System.out.println("4. Book a ticket");
                    int j = 0;
                    int index = -1;
                    System.out.println("Cineplex List:");
                    for(Cineplex cineplex :cathay){
                        System.out.printf("%s. %s\n",j,cineplex.getName());
                        j++;
                    }
                    do {
                        System.out.println("Select one of the cineplex index");
                        index = sc.nextInt();
                    } while (index < 0 || index > cathay.size()-1);
                    cine = cathay.get(index);
                    movieList = cine.getMovieList();

                    if(movieList.size()==0){
                        System.out.println("No Movie is airing in this cineplex");
                        break;
                    }

                    System.out.println("Which movie :");
                    for (int i = 0; i < movieList.size(); i++) {
                        if( (movieList.get(i).getStatus() == Status.NOW_SHOWING || movieList.get(i).getStatus() == Status.PREVIEW) ){
                            System.out.println(i + " " + movieList.get(i).getTitle() + " " + movieList.get(i).getStatus() );
                        }
                    }
                    int moviechoice = sc.nextInt();
                    if(moviechoice >= movieList.size()){
                        System.out.println("Please Choose appropriate Movie!");
                        break;
                    }
                    ts1 = movieList.get(moviechoice).getTimeSlots();
                    //Age requirement check
                    if (man.getAgetype().ordinal() < movieList.get(moviechoice).getAge_restriction().ordinal() ) {
                        System.out.println("Age requirement required to watch " + movieList.get(moviechoice).getAge_restriction() + " Movie");
                        break;
                    }
                    //Check booking type
                    if(movieList.get(moviechoice).getStatus() == Status.COMING_SOON || movieList.get(moviechoice).getStatus() == Status.END_OF_SHOWING)
                    if (ts1.size() == 0) {
                        System.out.println("The movie is coming soon or not showing now");
                        break;
                    }

                    System.out.println("Select a date");
                    String firstDate = ts1.get(0).getStringDate();
                    System.out.println(0 + " " + ts1.get(0).getStringDate());
                    datel.add(firstDate);
                    for (int i = 1; i < ts1.size(); i++) {
                        if (ts1.get(i - 1).getStringDate() != ts1.get(i).getStringDate()) {
                            datel.add(ts1.get(i).getStringDate());
                            System.out.println(i + " " + ts1.get(i).getStringDate());
                        }
                    }

                    int input = sc.nextInt();
                    dateS = datel.get(input);


                    System.out.println("Select Timeslot");
                    ArrayList<Integer> tsnum = new ArrayList<>();
                    int slot = 0;
                    for (int i = 0; i < ts1.size(); i++) {
                        if (ts1.get(i).getStringDate() == dateS) {
                            System.out.println(slot + " " + ts1.get(i).getStartTime() + "-" +ts1.get(i).getEndTime());
                            tsnum.add(i); slot++;
                        }
                    }
                    choice = sc.nextInt();

                    if (choice >= tsnum.size()) {
                        System.out.println("Please Choose appropriate timeslot!");
                        break;
                    }
                    tss = ts1.get(tsnum.get(choice));
                    //System.out.println("selected "+tsnum.get(choice));
                    //tss.getRoom().printSeats();


                    System.out.println("Select Qty: ");
                    Qty = sc.nextInt();
                    ArrayList<Integer> ticketagelist= new ArrayList<>();
                    for(int i=0;i<Qty;i++){
                        System.out.println("Selecting Age Category for Customer "+i);
                        System.out.println("0 for CHILD");
                        System.out.println("1 for STUDENT");
                        System.out.println("2 for SENIOR");
                        System.out.println("3 for ADULT");
                        int age = sc.nextInt();
                        if( (age>3) || (age<0) || age<movieList.get(moviechoice).getAge_restriction().ordinal() ){
                            Qty=-1;
                            break;
                        }
                        ticketagelist.add(age);
                    }
                    if(Qty == -1){
                        System.out.println("Age requirement required to watch " + movieList.get(moviechoice).getAge_restriction() + " Movie");
                        break;
                    }

                    LocalDate dt = LocalDate.parse(dateS, df);
                    Day d;
                    Integer starttime = Integer.parseInt( tss.getStartTime().substring(0,2) );
                    Integer endtime = Integer.parseInt( tss.getEndTime().substring(0,2) );
                    if (dt.getDayOfWeek() == DayOfWeek.MONDAY || dt.getDayOfWeek() == DayOfWeek.TUESDAY || dt.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                        d = Day.MON_TO_WED;
                    } else if (dt.getDayOfWeek() == DayOfWeek.FRIDAY && ( !(starttime <= 6 && 6 <= endtime) || (starttime>6) || (endtime<6)  ) ) {
                        d = Day.FRI_BEFORE_6;
                    } else if (dt.getDayOfWeek() == DayOfWeek.THURSDAY) {
                        d = Day.THURS;
                    }  else {
                        d = Day.REMAINING_DAYS;
                    }

                    for(int i=0; i<holidays.length;i++){
                        if(holidays[i].indexOf(dateS) > -1){
                            d = Day.HOLIDAY;
                        }
                    }

                    String transid = "Cinema :"+cine.getName()+" Movie title :"+movieList.get(moviechoice).getTitle()+" "+tss.getairingtimeformat()+" "+d+" "+tss.getRoom().getCinemaClass()+" "+movieList.get(moviechoice).getType();
                    System.out.println(transid);
                    seatdesc = tss.getRoom().getseattypedesc();
                    //System.out.println("Seatdesc : "+seatdesc);
                    String couples1 = seatdesc.substring(0,seatdesc.indexOf("Elite"));
                    String elite1 = seatdesc.substring(seatdesc.indexOf("Elite"),seatdesc.indexOf("Ulti"));
                    String ulti1 = seatdesc.substring(seatdesc.indexOf("Ulti"));
                    movieList.get(moviechoice).getTimeSlots().get(tsnum.get(choice)).getRoom().printSeats();
                    //Cinema c = movieList.get(moviechoice).getTimeSlots().get(tsnum.get(choice)).getRoom();
                    System.out.println(couples1);
                    System.out.println(elite1);
                    System.out.println(ulti1);
                    ArrayList<Seattype> selectedseattype = new ArrayList<>();
                    System.out.println("Select Seats: (Example: A12, B9 )");
                    for (int q = 0; q < Qty; q++) {
                        String selectseat = s.nextLine();

                        int row = Integer.valueOf(selectseat.toLowerCase().substring(0, 1).charAt(0) - 96) - 1;
                        int col = Integer.parseInt(selectseat.substring(1)) - 1 ;
                        //System.out.println("Gettype : "+tss.getRoom().getseattype(row,col)+" "+row+" "+col+tss.getRoom().checkseat(row, col));
                        if ((row<10) && (col<12) ) {
                            if(!tss.getRoom().checkseat(row, col)){
                                if(tss.getRoom().getseattype(row,col).ordinal() != Seattype.SEAT.ordinal()){
                                    q = q + 1;
                                    if((q) >= Qty){
                                        System.out.println("Sorry the seat required 2 seaters. Choose again!");
                                        q = q - 2;
                                    } else{
                                        tss.getRoom().book(row, col);
                                        selectedseattype.add(tss.getRoom().getseattype(row,col));
                                        selectedseattype.add(tss.getRoom().getseattype(row,col));
                                        System.out.println("Double seats selected!");
                                    }
                                }

                                if(tss.getRoom().getseattype(row,col).ordinal() == Seattype.SEAT.ordinal()){
                                    tss.getRoom().book(row, col);
                                    selectedseattype.add(tss.getRoom().getseattype(row,col));
                                    System.out.println("Seat selected!");
                                }

                            }else{
                                System.out.println("Sorry the seat is taken. Choose again!");
                                q = q - 1;
                            }
                        } else {
                            System.out.println("Sorry the seat is taken. Choose again!");
                            q = q - 1;
                        }
                    }


                    //Ticket create part
                    Ticket[] t = new Ticket[Qty];
                    ArrayList<Object> priceLists = getPricelistFromFile();
                    //String ageprice = priceLists.get(0).toString();
                    HashMap<String,Double> ageList = (HashMap<String,Double>)priceLists.get(0);
                    HashMap<String,Double> seatTypeList = (HashMap<String,Double>)priceLists.get(1);
                    HashMap<String,Double> cinemaClassList = (HashMap<String,Double>)priceLists.get(2);
                    HashMap<String,Double> movieClassList = (HashMap<String,Double>)priceLists.get(3);
                    HashMap<String,Double> dayList = (HashMap<String,Double>)priceLists.get(4);

                    for(int i=0;i<Qty;i++){
                        double ticketprice = 0;
                        //Calculating price
                        for (Map.Entry<String, Double> age : ageList.entrySet()) {
                            String keys = age.getKey();
                            Double value = age.getValue();
                            //System.out.println(keys+" "+value+" "+ AgeOfMovieGoer.values()[ticketagelist.get(i)].toString());
                            if(keys.equals( AgeOfMovieGoer.values()[ticketagelist.get(i)].toString()) ){
                                System.out.println("Calculating for "+AgeOfMovieGoer.values()[ticketagelist.get(i)].toString());
                                ticketprice += value;
                            }
                        }
                        for (Map.Entry<String, Double> seatType : seatTypeList.entrySet()) {
                            String keys = seatType.getKey();
                            Double value = seatType.getValue();
                            if(keys.equals( selectedseattype.get(i).toString() )){
                                System.out.println("Calculating for "+selectedseattype.get(i).toString());
                                ticketprice += value;
                            }
                        }
                        for (Map.Entry<String, Double> cinemaClass : cinemaClassList.entrySet()) {
                            String keys = cinemaClass.getKey();
                            Double value = cinemaClass.getValue();
                            if(keys.equals( tss.getRoom().getCinemaClass().toString() )){
                                System.out.println("Calculating for "+tss.getRoom().getCinemaClass().toString());
                                ticketprice += value;
                            }
                        }
                        for (Map.Entry<String, Double> movieClass : movieClassList.entrySet()) {
                            String keys = movieClass.getKey();
                            Double value = movieClass.getValue();
                            if(keys.equals( movieList.get(moviechoice).getType().toString() )){
                                System.out.println("Calculating for "+movieList.get(moviechoice).getType().toString());
                                ticketprice += value;
                            }
                        }
                        for (Map.Entry<String, Double> day : dayList.entrySet()) {
                            String keys = day.getKey();
                            Double value = day.getValue();
                            //System.out.println(keys+" "+value+" "+ d.toString());
                            if(keys.equals( d.toString()) ){
                                System.out.println("Calculating for "+d.toString());
                                ticketprice += value;
                            }
                        }
                        t[i] = new Ticket(1, AgeOfMovieGoer.values()[ticketagelist.get(i)] , movieList.get(moviechoice).getType(), tss.getRoom().getCinemaClass(), d, selectedseattype.get(i), ticketprice);
                        movieList.get(moviechoice).addsales(ticketprice); //add to movie
                    }
                    //Transaction trans = new Transaction(dtf.format(now).toString() +" "+ transid, t);
                    Transaction trans = new Transaction(dtf.format(now).toString() +" "+ transid,man.getName(),man.getMobile(),man.getEmail(),t);
                    man.getTransactionHistory().add(trans);

                    System.out.println(Qty + " Booking places!");
                    break;
                case 5:
                    System.out.println("5. View Booking History");
                    ArrayList<Transaction> temptrans = man.getTransactionHistory();
                    System.out.println("Here is your Transaction :");
                    for(int i=0;i<temptrans.size();i++){
                        System.out.println("Transaction "+temptrans.get(i).getId());
                        temptrans.get(i).printTickets();
                    }

                    break;

                // case 6:
                //     System.out.println("6. List Top 5 Movies by sales OR by overall ratings");

                //     // array for sorting
                //     Movie[] top5m = movieArr;
                //     System.out.println("1. by sales");
                //     System.out.println("2. by rating");
                //     choice = sc.nextInt();

                //     if(choice>2){
                //         System.out.println("Sorry, please select input appropriate value");
                //         break;
                //     }

                //     switch (choice) {
                //         case 1:
                //             // Sort by sales only
                //             Movie keyss;
                //             int js;
                //             for (int i = 1; i < top5m.length; i++) {
                //                 keyss = top5m[i];
                //                 js = i - 1;
                //                 while (js >= 0 && top5m[js].getSales() < keyss.getSales()) {
                //                     top5m[js + 1] = top5m[js];
                //                     js = js - 1;
                //                 }
                //                 top5m[js + 1] = keyss;
                //             }
                //             break;
                //         case 2:
                //             // Sort by Rating only
                //             Movie keys;
                //             int j;
                //             for (int i = 1; i < top5m.length; i++) {
                //                 keys = top5m[i];
                //                 j = i - 1;
                //                 while (j >= 0 && top5m[j].getrealrating() < keys.getrealrating()) {
                //                     top5m[j + 1] = top5m[j];
                //                     j = j - 1;
                //                 }
                //                 top5m[j + 1] = keys;
                //             }
                //             break;
                //     }
                //     System.out.println("Here are the top 5 list: ");
                //     int n = 5;
                //     if (top5m.length < 5) {
                //         n = top5m.length;
                //     }
                //     for (int i = 0; i < n; i++) {
                //         System.out.println(i + " Movie: " + top5m[i].getTitle() + " Rating: " + top5m[i].getRating()
                //                 + " Sales: " + top5m[i].getSales() + " Number of reviewer: "
                //                 + top5m[i].getnumberofreviewer());
                //     }
                //     System.out.println("Select movie to view review comment");
                //     choice=sc.nextInt();
                //     if(choice>=n || choice<0){
                //         //System.out.println("Sorry, please select input appropriate value");
                //         break;
                //     }
                //     ArrayList<Review> tempreview = top5m[choice].getreviewlist();
                //     for(int i=0;i<tempreview.size();i++){
                //         System.out.println("Comment "+i+": "+tempreview.get(i).getRemark());
                //     }


                //     break;
                // case 7:
                //     System.out.println("7. Give a movie review");
                //     System.out.println("List of all current movie with rating");
                //     for (int i = 0; i < movieArr.length; i++) {
                //         System.out.println(
                //                 i + " Movie " + movieArr[i].getTitle() + " current rating " + movieArr[i].getRating()
                //                         + " number of reviewer: " + movieArr[i].getnumberofreviewer());
                //     }
                //     int choose = sc.nextInt();
                //     if(choose>=movieArr.length){
                //         System.out.println("Sorry, Movie not found");
                //     }

                //     System.out.println("Give a rating from 1-5");
                //     int rating = sc.nextInt();
                //     sc = new Scanner(System.in);
                //     System.out.println("Give a review");
                //     String review = sc.nextLine();

                //     Review rv = new Review(rating, review);
                //     movieArr[choose].addReview(rv);
                //     ArrayList<Review> reviewlist = movieArr[choose].getreviewlist();
                //     movieArr[choose].updatereviewscore(reviewlist);

                //     System.out.println("Thank you for the review.");

                //     break;
                
                default:
                    break;
            }

        } while (option < 8 && option > 0);

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
