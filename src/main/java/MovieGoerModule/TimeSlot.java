package MovieGoerModule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeSlot {
    private String stringDate;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private ClassOfCinama movieClass;
    private Cinema room;

    private Movie airingmovie;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TimeSlot(String dateOfSlot, String startTime, String endTime, ClassOfCinama movieClass, Cinema roomStyle) {
        room = new Cinema();
        stringDate = dateOfSlot;

        this.movieClass = movieClass;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = roomStyle;

        this.date = LocalDate.parse(dateOfSlot, df);
        // System.out.println(date);
        // System.out.println(date.getDayOfWeek());
        this.room = new Cinema();

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

    public ClassOfCinama getMovieClass() {
        return movieClass;
    }

    public Movie getAiringmovie() {
        return airingmovie;
    }

    public Cinema getRoom() {
        return room;
    }
}
