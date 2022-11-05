package AdminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import MovieGoerModule.AgeOfMovieGoer;

public class configureSettings {
    private final static String PRICELIST_FILE_NAME = "Pricelist.txt";
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Choose an option:");
            System.out.println("1: Change ticket price");
            System.out.println("2: Add/Remove holiday");
            System.out.println("3: Add/Remove showtimes");
            System.out.println("4: Back");
            choice = sc.nextInt();
            sc.nextLine();  //clear buffer
            switch(choice){
                case 1:
                    //change ticket price
                    //retrieve pricelist from pricelist.txt
                    printPricelist();
                    ArrayList<Object> priceList = getPricelistFromFile();
                    //select category to change

                    //select the "age" to change

                    //enter new value

                    //set value into category arraylist
                    //set category arraylist into pricelist arraylist
                    //save updated pricelist arraylist into pricelist.txt 

                    break;

                case 2:
                    addHolidays ad = new addHolidays();
                    System.out.println("Enter a holiday date (DD/MM/YYYY):");
                    String date = sc.nextLine();
                    if(dateChecker.check(date)){ //check format
                        ad.addDay(date);
                        System.out.println("Added successfully!");
                    }
                    else{
                        System.out.println("Invalid date!");
                    }
                    
                    break;

                case 3:
                    //showtime changes
                    break;

                case 4:
                default:
                    System.out.println("Going back...");
                    break;
            }
        } while(choice != 4);

    }


    public static ArrayList<Object> getPricelistFromFile() throws IOException, ClassNotFoundException{
        ArrayList<Object> priceList;

        try {
            FileInputStream fileInputStream2 = new FileInputStream(PRICELIST_FILE_NAME);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            priceList = (ArrayList<Object>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Pricelist retrieved from File");

        } catch (FileNotFoundException e) {
            FileOutputStream fileOutputStream = new FileOutputStream(PRICELIST_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            priceList = generateDummyData();
            objectOutputStream.writeObject(priceList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Pricelist File not found, creating new Pricelist File");
        }

        return priceList;
    }

    public static void addPricelistToFile(ArrayList<Object> priceList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(PRICELIST_FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(priceList);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.printf("Pricelist added to File\n");
    }


    private static ArrayList<Object> generateDummyData() throws ClassNotFoundException, IOException{
        ArrayList<Object> priceList = new ArrayList<>();
        HashMap<String,Double> ageList = new HashMap<String,Double>();
        HashMap<String,Double> seatTypeList = new HashMap<String,Double>();
        HashMap<String,Double> movieClassList = new HashMap<String,Double>();
        HashMap<String,Double> dayList = new HashMap<String,Double>();

        ageList.put("CHILD", 2.0);
        ageList.put("STUDENT", 3.0);
        ageList.put("SENIOR", 2.0);
        ageList.put("ADULT", 4.0);

        seatTypeList.put("SEAT",2.0);
        seatTypeList.put("COUPLE_SEAT",4.0);
        seatTypeList.put("ELITE_SEAT",5.0);
        seatTypeList.put("ULTIMA_SEAT",7.0);

        movieClassList.put("REGULAR",3.0);
        movieClassList.put("DOLBY",6.0);
        movieClassList.put("PLATINUM",10.0);

        dayList.put("MON_TO_WED",2.0);
        dayList.put("THURS",1.5);
        dayList.put("FRI_BEFORE_6",3.0);
        dayList.put("HOLIDAY",6.0);
        dayList.put("REMAINING_DAYS",4.0);
        
        
        priceList.add(ageList);
        priceList.add(seatTypeList);
        priceList.add(movieClassList);
        priceList.add(dayList);
        
        return priceList;
    }

    private static void printPricelist() throws ClassNotFoundException, IOException{
        ArrayList<Object> pricelist = getPricelistFromFile();
        HashMap<String,Double> ageList = (HashMap<String,Double>)pricelist.get(0);
        HashMap<String,Double> seatTypeList = (HashMap<String,Double>)pricelist.get(1);
        HashMap<String,Double> movieClassList = (HashMap<String,Double>)pricelist.get(2);
        HashMap<String,Double> dayList = (HashMap<String,Double>)pricelist.get(3);

        System.out.println("Printing out Pricelist\n");
        System.out.println("Age");
        System.out.println("------------------");
        for (Map.Entry<String, Double> age : ageList.entrySet()) {
            String key = age.getKey();
            Double value = age.getValue();
            System.out.printf("%s: %.2f\n",key,value);
        }
        System.out.println("");

        System.out.println("Seat Type");
        System.out.println("------------------");
        for (Map.Entry<String, Double> seatType : seatTypeList.entrySet()) {
            String key = seatType.getKey();
            Double value = seatType.getValue();
            System.out.printf("%s: %.2f\n",key,value);
        }
        System.out.println("");


        System.out.println("Movie Class");
        System.out.println("------------------");
        for (Map.Entry<String, Double> movieClass : movieClassList.entrySet()) {
            String key = movieClass.getKey();
            Double value = movieClass.getValue();
            System.out.printf("%s: %.2f\n",key,value);
        }
        System.out.println("");


        System.out.println("Day");
        System.out.println("------------------");
        for (Map.Entry<String, Double> day : dayList.entrySet()) {
            String key = day.getKey();
            Double value = day.getValue();
            System.out.printf("%s: %.2f\n",key,value);
        }
        System.out.println("");

    }

}