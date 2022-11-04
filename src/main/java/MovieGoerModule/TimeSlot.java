package MovieGoerModule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeSlot {
    private String stringDate;
    private LocalDate date;
    private int startTime;
    private int endTime;
    private ClassOfCinama movieClass;
    private Cinema room;

    public TimeSlot(String dateOfSlot, int startTime, int endTime, ClassOfCinama movieClass) {
        room = new Cinema();
        stringDate = dateOfSlot;

        this.movieClass = movieClass;
        this.startTime = startTime;
        this.endTime = endTime;

        this.date = LocalDate.parse(dateOfSlot);
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

    }

    public String getStringDate() {
        return stringDate;
    }
}
