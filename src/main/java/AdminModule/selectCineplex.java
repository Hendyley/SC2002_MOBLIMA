package AdminModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MovieGoerModule.Cinema;
import MovieGoerModule.Cineplex;
import MovieGoerModule.Movie;
import MovieGoerModule.Status;
import MovieGoerModule.TimeSlot;

public class selectCineplex{

    public static Cineplex select() throws ClassNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        int index;
        ArrayList <Cineplex> cineList = testDB.getCineplexListFromFile();

        do{
            System.out.println("Displaying cineplexes:");
            for(int i = 0; i < cineList.size(); i++){
                System.out.println(i + ": " + cineList.get(i).getName());
            }
            System.out.println("Enter name of cineplex:");
            String cineplexName = sc.nextLine();
            index = testDB.getCineplexIndex(cineList, cineplexName);
        } while(index != -1);
        //end of selecting cineplex

        //-----------BELOW IS FOR ADDING TIMESLOTS(WILL RELOCATE CODE)---------------------------
        System.out.println("Movie list:");

        //movie listing in cineplex
        Cineplex c = cineList.get(index);
        ArrayList<Movie> movieList = c.getMovieList();

        //ask staff for date
        System.out.println("Enter a date:");
        String date;
        do{
            date = sc.nextLine();
            if(!dateChecker.check(date))
                System.out.println("Invalid date! Try again");
        }while(!dateChecker.check(date));

        //create timeslot array
        ArrayList<TimeSlot> tsList = new ArrayList<TimeSlot>();

        //loop movelist get all timeslots
        for(int i = 0; i < movieList.size(); i++){
            Movie m = movieList.get(i);
            ArrayList <TimeSlot> mTSList = m.getTimeSlots();
            for(int j = 0; j < mTSList.size(); j++){
                //if (same date)
                if(mTSList.get(j).getStringDate().compareTo(date) == 0){
                    tsList.add(mTSList.get(j));
                }
            }
        }

        //print out time slots
        for(int i = 0; i < tsList.size(); i++){
            System.out.println("Start: " + tsList.get(i).getStartTime());
            System.out.println("End: " + tsList.get(i).getEndTime());
        }

        //print now_showing movies
        for(int i = 0; i < movieList.size(); i++){
            Movie mov = movieList.get(i);
            if(mov.getStatus() == Status.NOW_SHOWING){
                System.out.println(mov.getTitle());
            }
        }

        //select a movie
        System.out.println("Enter movie to add timeslot:");
        String title = sc.nextLine();
        index = -1;
        index = MovieDB.getMovieIndex(movieList, title);
        Movie selectedMovie = movieList.get(index);
        if(index == -1){
            System.out.println("Does not exist");
        }

        //ask for start time
        System.out.println("Enter start and end time");
        String start = sc.nextLine();
        String end = sc.nextLine();

        //print and select room
        System.out.println("Rooms:");
        for(int i = 0; i < c.getNumRooms(); i++){
            System.out.print(i + " ");
        }

        //check within index range
        int room;
        do{
            room = sc.nextInt();
        }while(room >= 0 && room <= c.getNumRooms() - 1);

        Cinema selectedRoom = c.getRoom(index);
        ArrayList<TimeSlot> same_movie = new ArrayList<TimeSlot>();
        ArrayList<TimeSlot> other_movie = new ArrayList<TimeSlot>();
        //for loop timeslot_day, split same movie other movie
        for(int i = 0; i < tsList.size(); i++){
            if(tsList.get(i).getAiringmovie().getTitle().compareTo(title) == 0){
                same_movie.add(tsList.get(i));
            }
            else{
                other_movie.add(tsList.get(i));
            }
        }

        //check for movies in the same room
        ArrayList<TimeSlot> same_room = new ArrayList<TimeSlot>();
        for(int i = 0; i < other_movie.size(); i++){
            if(other_movie.get(i).getRoom() == selectedRoom){
                same_room.add(other_movie.get(i));
            }
        }
        boolean clash = false;
        for(int i = 0; i < same_room.size(); i++){
            if(start < same_room.get(i).getStartTime() || end > same_room.get(i).getEndTime()){
                clash = true;
                System.out.println("clashing timeslot");
                //return sth
            }
        }
        //timeslot constructor
        //TimeSlot(String dateOfSlot, String startTime, String endTime, ClassOfCinama movieClass, Cinema RoomStyle)
        if(!clash){
            ArrayList<TimeSlot> movieTS = selectedMovie.getTimeSlots();
            //incomplete will continue
        }

        
        return cineList.get(index);

    }
}
