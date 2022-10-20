package AdminModule;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminModuleApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int optionSelected;
        String staffUsername;
        String staffPassword;
        Staff staff1;
        ArrayList<Staff> staffList;

        System.out.println("Admin Module");
        System.out.println("Select options:");
        System.out.println("1.Sign Up");
        System.out.println("2.Login");
        optionSelected = sc.nextInt();
        sc.nextLine();

        switch(optionSelected){
            case 1:
                System.out.println("Sign Up");
                System.out.print("Username:");
                staffUsername = sc.nextLine();
                System.out.print("Password:");
                staffPassword = sc.nextLine();

                //add staff
                staff1 = new Staff(staffUsername,staffPassword);
                staffList = getStaffListFromFile();
                addStaffToFile(staffList,staff1);
                break;
            case 2:
                System.out.println("Login");
                System.out.print("Username:");
                staffUsername = sc.nextLine();
                System.out.print("Password:");
                staffPassword = sc.nextLine();

                //login
                staff1 = new Staff(staffUsername,staffPassword);
                staffList = getStaffListFromFile();
                login(staffList,staff1);

                break;
            default:
                System.out.println("default");
                printStaffList();
        }


    }

    public static ArrayList<Staff> getStaffListFromFile() throws IOException,ClassNotFoundException {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        try {
            FileInputStream fileInputStream2 = new FileInputStream("staffList.txt");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            staffList = (ArrayList<Staff>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Staff List retrieved from File");

        } catch (FileNotFoundException e) {
            FileOutputStream fileOutputStream = new FileOutputStream("staffList.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(staffList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Staff List File not found, creating new Staff List File");
        }

        return staffList;
    }

    public static void addStaffToFile(ArrayList<Staff> staffList, Staff staff) throws IOException{

        if(!isUsernameExist(staffList,staff)){
            staffList.add(staff);
            FileOutputStream fileOutputStream = new FileOutputStream("staffList.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(staffList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Staff added to File");
            return;
        }
        System.out.println("Staff Username have been taken");

    }

    public static boolean isUsernameExist(ArrayList<Staff> staffList, Staff staffToAdd) {
        String staffUsername = staffToAdd.getStaffUsername();
        for (Staff s : staffList){
            if (s.getStaffUsername().equals(staffUsername)) {
                return true;
            }
        }
        return false;
    }

    public static boolean login(ArrayList<Staff>staffList, Staff staffToLogin){
        String staffUsername = staffToLogin.getStaffUsername();
        String staffPassword = staffToLogin.getStaffPassword();
        for (Staff s : staffList){
            if (s.getStaffUsername().equals(staffUsername)
                    && s.getStaffPassword().equals(staffPassword)) {
                System.out.println("Login Success");
                return true;
            }
        }
        System.out.println("Incorrect Username or Password");
        return false;
    }

    public static void printStaffList() throws IOException, ClassNotFoundException {
        //get updated staffList from file
        ArrayList<Staff> staffList = getStaffListFromFile();
        for(Staff s: staffList){
            System.out.printf("username: %s, password: %s\n",s.getStaffUsername(),s.getStaffPassword());
        }
    }

}