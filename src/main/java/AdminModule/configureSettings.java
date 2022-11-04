package AdminModule;

import java.util.Scanner;

public class configureSettings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Choose an option:");
            System.out.println("1: Change ticket price");
            System.out.println("2: Add/Remove holiday");
            System.out.println("3: Back");
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
                    if(date.matches("\\d{2}/\\d{2}/\\d{4}")){ //check format
                        ad.addDay(date);
                        System.out.println("Added successfully!");
                    }
                    else{
                        System.out.println("Invalid date!");
                    }
                    
                    break;

                case 3:
                default:
                    System.out.println("Going back...");
                    break;
            }
        } while(choice != 3);

    }
}
