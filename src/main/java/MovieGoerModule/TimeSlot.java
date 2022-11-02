package MovieGoerModule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeSlot {
    private String stringDate;
    private Calendar date;
    private int time;
    private TypeOfMovie movieType;
    private ClassOfCinama movieClass;
    private Cinema room;

    public TimeSlot(String dateOfSlot, int time, TypeOfMovie movieType, ClassOfCinama movieClass) throws Exception {
        room = new Cinema();
        stringDate = dateOfSlot;
        this.movieType = movieType;
        this.movieClass = movieClass;

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter1.parse(dateOfSlot));
        date = cal;
        // System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    }

    public String getStringDate() {
        return stringDate;
    }
}
