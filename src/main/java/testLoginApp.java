import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import MovieGoerModule.Account;
import MovieGoerModule.MovieGoer;
import AdminModule.Staff;

public class testLoginApp {
    private final static String ACCOUNT_FILE_NAME = "AccountList.txt";
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Account> accountList;
    private static String username;
    private static String password;
    private static Account account;
    public static void main(String[] args) throws ClassNotFoundException, IOException{
        
        int accountOption;
        
        //generateDummyData();
        printAccountList();
        // do{
            System.out.println("    testLoginApp    ");
            System.out.println("********************");
            System.out.println("1. Login into Account");
            System.out.println("2. Continue as guest");
            System.out.println("3. Exit");
            System.out.println("********************");
            accountOption = sc.nextInt();
            sc.nextLine();

            switch(accountOption){
                case 1:
                    switch_case_login();
                    break;
                case 2:
                    switch_case_guest();
                    break;
                default:
                    break;
            } 
        // }while(accountOption != 3);

        sc.close();
    }

    public static void switch_case_login() throws ClassNotFoundException, IOException{

        System.out.println("Login");
        System.out.print("Username:");
        username = sc.nextLine();
        System.out.print("Password:");
        password = sc.nextLine();

        account = new MovieGoer(username, password);
        accountList = getAccountListFromFile();
        login(accountList,account);
        System.out.println();

    }

    public static void switch_case_guest(){
        System.out.println("Continued as Guest");
    }

    public static ArrayList<Account> getAccountListFromFile() throws IOException, ClassNotFoundException {
        accountList = new ArrayList<Account>();
        try {
            FileInputStream fileInputStream2 = new FileInputStream(ACCOUNT_FILE_NAME);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            accountList = (ArrayList<Account>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Account List retrieved from File");

        } catch (FileNotFoundException e) {
            FileOutputStream fileOutputStream = new FileOutputStream(ACCOUNT_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Account List File not found, creating new Account List File");
        }

        return accountList;
    }

    public static void addAccountToFile(ArrayList<Account> accountList, Account account) throws IOException {
        if (!isUsernameExist(accountList, account)) {
            accountList.add(account);
            FileOutputStream fileOutputStream = new FileOutputStream(ACCOUNT_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.printf("%s Account added to File\n",account.getRole());
            return;
        }
        System.out.println("Username have been taken");

    }

    public static boolean isUsernameExist(ArrayList<Account> accountList, Account accountToAdd) {
        username = accountToAdd.getUsername();
        for (Account acc : accountList) {
            if (acc.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void generateDummyData() throws ClassNotFoundException, IOException{
 
        System.out.println("Adding Dummy Data to Account File");
        account = new Staff("admin", "admin123");
        accountList = getAccountListFromFile();
        addAccountToFile(accountList,account);

        account = new MovieGoer("user1", "user123");
        accountList = getAccountListFromFile();
        addAccountToFile(accountList,account);

        account = new MovieGoer("user2", "user234");
        accountList = getAccountListFromFile();
        addAccountToFile(accountList,account);
        System.out.println("Finshed Adding Dummy Data");
    }

    public static boolean login(ArrayList<Account> accountList, Account accountToLogin) {
        username = accountToLogin.getUsername();
        password = accountToLogin.getPassword();
        for (Account acc : accountList) {
            if (acc.getUsername().equals(username)
                    && acc.getPassword().equals(password)) {
                System.out.println("Login Success");
                return true;
            }
        }
        System.out.println("Incorrect Username or Password");
        return false;
    }

    public static void printAccountList() throws IOException, ClassNotFoundException {
        // get updated staffList from file
        accountList = getAccountListFromFile();
        for (Account acc : accountList) {
            System.out.printf("username: %s, password: %s\n", acc.getUsername(), acc.getPassword());
        }
        System.out.println();
    }

}
