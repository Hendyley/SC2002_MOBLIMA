package AdminModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MovieGoerModule.Cinema;
import MovieGoerModule.Cineplex;
import MovieGoerModule.Movie;
import MovieGoerModule.Status;
import MovieGoerModule.TimeSlot;

public class addTimeslot {
    // public static void change(Cineplex cine) {
    //     Scanner sc  = new Scanner(System.in);
    //     System.out.println("Enter the date of show:");
    //     String date = sc.nextLine();
    //     while(!dateChecker.check(date)){
    //         System.out.println("Invalid date! Try again!");
    //     }
    //     System.out.println("Enter the start time:");
    //     String startTime = sc.nextLine();
    //     System.out.println("Enter the end time:");
    //     String endTime = sc.nextLine();
        
    //     System.out.println("Enter the movieClass:");
    //     System.out.println("1: REGULAR");
    //     System.out.println("2: PLATINUM");
    //     System.out.println("3: DOLBY");
    //     int choice = sc.nextInt();
    //     ClassOfCinema movieClass;
    //     switch(choice){
    //         case 1:
    //             movieClass = ClassOfCinema.REGULAR;
    //             break;

    //         case 2:
    //             movieClass = ClassOfCinema.PLATINUM;
    //             break;

    //         case 3:
    //             movieClass = ClassOfCinema.DOLBY;
    //             break;

    //         default:
    //             movieClass = ClassOfCinema.REGULAR;
    //             break;
    //     }
        
    //     for(int i = 0; i < cine.getRoomList().size(); i++){
    //         //print id of rooms
    //     }
    //     System.out.println("Select a room:");
    //     int room = sc.nextInt();
    //     Cinema c = cine.getRoom(room);
        
    //     // TimeSlot ts = new TimeSlot(date, startTime, endTime, movieClass, c);
    //     // m.addSlot(ts);
    // }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        addTimeslot.test();
    }
    
    //-----------------------USE THIS PART-----------------------------------
    public static void test() throws ClassNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);

        //print out list of cineplex
        ArrayList<Cineplex> cList = cineplexDB.getCineplexListFromFile();
        cineplexDB.printCineplexList();

        //select cineplex (enter name and get index)
        int cineplexindex;
        while(true){
            System.out.println("Enter the name of cineplex:");
            String nameCineplex = sc.nextLine();
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
        //printTimeSlot.printTS(timeslot_day);

        //loop movieList, print NOW_SHOWING
        System.out.println("Movies NOW_SHOWING:");
        for(int i = 0; i < movieList.size(); i++){
            Movie m = movieList.get(i);
            if(m.getStatus() == Status.NOW_SHOWING){
                System.out.println(m.getTitle());
            }
        }

        //staff select movie (check if movie exists)
        int movieIndex;
        String title;
        Movie chosenMovie;
        ArrayList<Movie> movieDBList = MovieDB.getMovieListFromFile();
        while(true){
            System.out.println("Enter movie title:");
            title = sc.nextLine();
            if(cineplexDB.isExistingMovie(movieList, title)){
                movieIndex = cineplexDB.getMovieIndex(movieList, title);
                chosenMovie = movieList.get(movieIndex);
                break;
            }
            else if(MovieDB.isExistingMovie(movieDBList, title)){
                int index = MovieDB.getMovieIndex(movieDBList, title);
                chosenMovie = movieDBList.get(index);
            }
            else{
                System.out.println("Movie does not exist. Try again.");
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
        Cinema chosenRoom = new Cinema();
        while(true){
            System.out.println("Choose a room:");
            chosenRoomID = sc.nextLine();
            for(int i = 0; i < roomList.size(); i++){
                if(roomList.get(i).getID().compareTo(chosenRoomID) == 0){
                    chosenRoom = roomList.get(i);
                    flag = true;
                }
            }
            
            if(flag) break;
            else{
                System.out.println("Room does not exist...");
            }
        }

        //check for time slot clashes in same room
        ArrayList<TimeSlot> roomTS = new ArrayList<TimeSlot>();
        for(TimeSlot ts : timeslot_day){
            if(ts.getRoom().equals(chosenRoom)){
                roomTS.add(ts);
            }
        }

        //print timeslots
        //input start time
        String startTime;
        String endTime;
        boolean clash = false;
        do{
            while(true){

                System.out.println("Time slots:");
                for(TimeSlot ts : roomTS){
                    System.out.println(ts.getairingtimeformat());
                }

                System.out.println("Enter start time:");
                startTime = sc.nextLine();
                if(timeChecker.isValidTime(startTime)){
                    endTime = TimeSlot.calculateEndTime(startTime, chosenMovie.getMovieDurationMin());
                    break;
                }
                else{
                    System.out.println("Invalid time. Try again");
                }
            }

            int startChosen = Integer.parseInt(startTime);  //start time input
            int endChosen = Integer.parseInt(endTime);

            for(TimeSlot ts : roomTS){
                int end = Integer.parseInt(ts.getEndTime());
                int start = Integer.parseInt(ts.getStartTime());
                if((startChosen >= start && startChosen <= end) || (endChosen >= start && endChosen <= end)
                    || (startChosen <= start && endChosen >= end)){
                    clash = true;
                    System.out.println("TIME SLOT CLASH");
                    System.out.println("Enter another timeslot or 0 to exit");
                }
            }

        } while(clash || startTime.compareTo("0") == 0 );

        if(!clash){
            System.out.println("Time slot successfully added!");

        //cases for clashes
        //                  start----end
        //       start-------------------------------end
        //start---------------end
        //                          start---------------------end
        //start-----------------------------------------------end

            TimeSlot toAdd = new TimeSlot(date, startTime, chosenRoom, title, 
                chosenMovie.getMovieDurationMin(), chosenMovie.getType());
            chosenMovie.addTimeSlot(toAdd);  //create set timeslot setTimeSlot(TimeSlot ts)
            chosenCineplex.setMovie(movieIndex, chosenMovie);     //add back movie w updated ts
            cList.set(cineplexindex, chosenCineplex);      //add back updated cineplex
            cineplexDB.addCineplexListToFile(cList);    //write back to file
        }
        else{
            System.out.println("Exiting...");
            return; //user inputs 0 above
        }

    }

}
