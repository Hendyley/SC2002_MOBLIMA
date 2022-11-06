package AdminModule;

import java.io.IOException;
import java.util.Scanner;

import MovieGoerModule.Cineplex;

public class configureSettings {
    public static void settings() throws ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Choose an option:");
            System.out.println("1: Change ticket price");
            System.out.println("2: Add/Remove holiday");
            System.out.println("3: Add/Remove showtimes");
            System.out.println("4: Movie listing");
            System.out.println("5: Back");
            choice = sc.nextInt();
            sc.nextLine();  //clear buffer
            switch(choice){
                case 1:
                    //change ticket price
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
                    Cineplex cine = selectCineplex.select();
                    timeslotChange.change(cine);
                    break;

                case 4:
                    //change movie listings to display sales/ratings
                    break;

                case 5:
                default:
                    System.out.println("Going back...");
                    break;
            }
        } while(choice != 4);

    }
}
