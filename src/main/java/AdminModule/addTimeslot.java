package AdminModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MovieGoerModule.Cinema;
import MovieGoerModule.Cineplex;
import MovieGoerModule.ClassOfCinama;
import MovieGoerModule.Movie;
import MovieGoerModule.Status;
import MovieGoerModule.TimeSlot;

public class addTimeslot {
    public static void change(Cineplex cine) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the date of show:");
        String date = sc.nextLine();
        while(!dateChecker.check(date)){
            System.out.println("Invalid date! Try again!");
        }
        System.out.println("Enter the start time:");
        String startTime = sc.nextLine();
        System.out.println("Enter the end time:");
        String endTime = sc.nextLine();
        
        System.out.println("Enter the movieClass:");
        System.out.println("1: REGULAR");
        System.out.println("2: PLATINUM");
        System.out.println("3: DOLBY");
        int choice = sc.nextInt();
        ClassOfCinama movieClass;
        switch(choice){
            case 1:
                movieClass = ClassOfCinama.REGULAR;
                break;

            case 2:
                movieClass = ClassOfCinama.PLATINUM;
                break;

            case 3:
                movieClass = ClassOfCinama.DOLBY;
                break;

            default:
                movieClass = ClassOfCinama.REGULAR;
                break;
        }
        
        for(int i = 0; i < cine.getRoomList().size(); i++){
            //print id of rooms
        }
        System.out.println("Select a room:");
        int room = sc.nextInt();
        Cinema c = cine.getRoom(room);
        
        TimeSlot ts = new TimeSlot(date, startTime, endTime, movieClass, c);
        // m.addSlot(ts);
    }

    public void test() throws ClassNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);

        //print out list of cineplex
        ArrayList<Cineplex> cList = cineplexDB.getCineplexListFromFile();
        cineplexDB.printCineplexList();

        //select cineplex (enter name and get index)
        int cineplexindex;
        while(true){
            System.out.println("Enter the name of cineplex:");
            String nameCineplex = sc.nextLine();
            sc.nextLine(); //clear buffer
            if(cineplexDB.isExistingCineplex(cList, nameCineplex)){
                cineplexindex = cineplexDB.getCineplexIndex(cList, nameCineplex);
                break;
            }
            else{
                System.out.println("Cineplex does not exist! Try again!");
            }
        }

        //enter a date
        System.out.println("Enter the date for showtime (DD/MM/YYYY):");
        String date;
        while(true){
            date = sc.nextLine();
            sc.nextLine();//clear buffer
            if(!dateChecker.check(date)){
                System.out.println("Invalid date. Try again.");
            }
            else{
                break;
            }
        }

        //get whole movie list
        Cineplex chosenCineplex = cList.get(cineplexindex);
        ArrayList<Movie> movieList = chosenCineplex.getMovieList();

        //create timeslot array
        ArrayList<TimeSlot> timeslot_day = new ArrayList<TimeSlot>();

        //get timeslots for same date
        //from movieList get showtimes for movies on the same date

        //looping through entire movieList
        for(int i = 0; i < movieList.size(); i++){
            ArrayList<TimeSlot> temp = movieList.get(i).getTimeSlots();

            //looping through timeslots for movies
            for(int j = 0; j < temp.size(); j++){
                String tempDate = temp.get(j).getStringDate();

                //if same date add into time slot array
                if(date.compareTo(tempDate) == 0){
                    timeslot_day.add(temp.get(j));
                }
            }
        }

        //print timeslot_day
        printTimeSlot.printTS(timeslot_day);

        //loop movieList, print NOW_SHOWING
        System.out.println("Movies NOW_SHOWING:");
        for(int i = 0; i < movieList.size(); i++){
            Movie m = movieList.get(i);
            if(m.getStatus() == Status.NOW_SHOWING){
                System.out.println(m.getTitle());
            }
        }

        //staff select movie
        int movieIndex;
        String title;
        Movie chosenMovie;
        while(true){
            System.out.println("Enter movie title:");
            title = sc.nextLine();
            if(MovieDB.isExistingMovie(movieList, title)){
                movieIndex = MovieDB.getMovieIndex(movieList, title);
                chosenMovie = movieList.get(movieIndex);
                break;
            }
            else{
                System.out.println("Movie does not exist. Try again.");
            }
        }

        //enter start time and end time
        String startTime, endTime;
        while(true){
            System.out.println("Enter start time:");
            startTime = sc.nextLine();
            if(timeChecker.isValidTime(startTime)){
                break;
            }
            else{
                System.out.println("Invalid time. Try again");
            }
        }

        while(true){
            System.out.println("Enter end time:");
            endTime = sc.nextLine();
            if(timeChecker.isValidTime(endTime)){
                break;
            }
            else{
                System.out.println("Invalid time. Try again");
            }
        }

        //print cinema list (should roomID be integer or string)
        ArrayList<String> idList = new ArrayList<String>();
        ArrayList<Cinema> roomList = chosenCineplex.getRoomList();
        System.out.println("ID of rooms");
        for(int i = 0; i < roomList.size(); i++){
            String roomID = roomList.get(i).getID();
            System.out.println("Room "+ (i+1) + ": " + roomID);
            idList.add(roomID);
        }

        //staff enter roomID
        String chosenRoomID;
        boolean flag = false;
        Cinema chosenRoom;
        while(true){
            chosenRoomID = sc.nextLine();
            for(int i = 0; i < idList.size(); i++){
                if(idList.get(i).compareTo(chosenRoomID) == 0){
                    chosenRoom =  roomList.get(i);
                    flag = true;
                }
            }
            if(flag) break;
            else{
                System.out.println("Room does not exist...");
            }
        }

        //split timeslot_day into same_movie and other_movie
        ArrayList<TimeSlot> same_movie = new ArrayList<TimeSlot>();
        ArrayList<TimeSlot> other_movie = new ArrayList<TimeSlot>();
        for(int i = 0; i < timeslot_day.size(); i++){
            TimeSlot temp = timeslot_day.get(i);
            if(timeslot_day.get(i).getAiringmovie() == chosenMovie){
                same_movie.add(temp);
            }
            else{
                other_movie.add(temp);
            }
        }
        boolean clash = false;
        int startChosen = Integer.parseInt(startTime);  //start time input
        for(int i = 0; i < same_movie.size(); i++){
            int end = Integer.parseInt(same_movie.get(i).getEndTime());
            if(startChosen < end){
                clash = true;
                System.out.println("Time slot clashes!");
                break;
            }
        }

        //check for time slot clashes in same room
    
    }
}
