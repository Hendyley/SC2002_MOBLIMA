package MovieGoerModule;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeSlot implements Serializable{
    private String stringDate;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private ClassOfCinema movieClass;
    private Cinema room;
    // private Movie airingmovie;
    private String movieName;
    private int movieDuration;
    private TypeOfMovie movieType;

    private transient DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public TimeSlot(String dateOfSlot, String startTime, String endTime, ClassOfCinema movieClass, Cinema RoomStyle) {
        room = new Cinema();
        stringDate = dateOfSlot;

        this.movieClass = movieClass;
        this.startTime = startTime;
        this.endTime = endTime;

        this.date = LocalDate.parse(dateOfSlot, df);
        // System.out.println(date);
        // System.out.println(date.getDayOfWeek());
        this.room = RoomStyle;

    }

    public TimeSlot(String dateOfSlot,String startTime,Cinema roomStyle, String movieName, 
        int movieDuration, TypeOfMovie movieType){
            this.stringDate = dateOfSlot;
            this.date = LocalDate.parse(dateOfSlot, df);
            this.startTime = startTime;
            calculateEndTime(startTime,movieDuration);

            this.room = roomStyle;
            this.movieName = movieName;
            this.movieDuration = movieDuration;
            this.movieType = movieType;
        }


    public String getStringDate() {
        return stringDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getairingtimeformat() {
        return stringDate + " at " + startTime + "-" + endTime;
    }

    public ClassOfCinema getMovieClass() {
        return movieClass;
    }

    public String getMovieName(){
        return movieName;
    }

    public int getMovieDuration(){
        return movieDuration;
    }

    public TypeOfMovie getMovieType(){
        return movieType;
    }

    // public Movie getAiringmovie() {
    //     return airingmovie;
    // }

    public Cinema getRoom() {
        return room;
    }


    public void calculateEndTime(String startTime, int movieDuration){
        String startHourStr = startTime.substring(0,2);
        String startMinStr = startTime.substring(2, 4);
        int endHour = Integer.parseInt(startHourStr);
        int endMin = Integer.parseInt(startMinStr);

        int movieHour = movieDuration/60;
        int movieMin = movieDuration - (movieHour * 60);
        int bufferMin = 20;

        endMin  = ((endMin + movieMin + bufferMin)/10) *10;
        if(endMin >= 60){
            endMin = endMin - 60;
            endHour += 1;
        }
        endHour = endHour + movieHour;

        if(endMin < 10){
            this.endTime = Integer.toString(endHour) + "0" +Integer.toString(endMin);
        }else{
            this.endTime = Integer.toString(endHour) + Integer.toString(endMin);
        }
    }
}
