package AdminModule;

import java.util.ArrayList;

public class addHolidays {

    public void addDay(String date){
        String filename = "holidays.txt";
        try{
            ArrayList al = holidayTextDB.readHolidays(filename);
            Holiday d = new Holiday(date);
            al.add(d);
            holidayTextDB.saveHoliday(filename, al);
        } catch(Exception e){ 
            System.out.println("IOException > " + e.getMessage());
        }
        
    }
}
