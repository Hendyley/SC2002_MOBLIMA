package AdminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import MovieGoerModule.Cinema;
import MovieGoerModule.Cineplex;
import MovieGoerModule.ClassOfCinama;
import MovieGoerModule.Movie;

public class cinexplexDB {
    private final static String Cineplex_FILE_NAME = "Cineplex.txt";

    public static ArrayList<Cineplex> getCineplexListFromFile() throws IOException, ClassNotFoundException{
        ArrayList<Cineplex> cineplexList;

        try{
            FileInputStream fileInputStream2 = new FileInputStream(Cineplex_FILE_NAME);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            cineplexList = (ArrayList<Cineplex>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Cineplex List retrieved from File");           
        }catch(FileNotFoundException e){
            FileOutputStream fileOutputStream = new FileOutputStream(Cineplex_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            cineplexList = generateDummyData();
            objectOutputStream.writeObject(cineplexList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Cineplex List File not found, creating new Cineplex List File");           
        }

        return cineplexList;
    }

    public static void addCineplexListToFile(ArrayList<Cineplex> CineplexList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(Cineplex_FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(CineplexList);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.printf("Cineplex Lists added to File\n");
    }

    public static boolean isExistingCineplex(ArrayList<Cineplex> cineplexList, String newCineplexnameCineplex){
        for(Cineplex cine: cineplexList){
            if(cine.getName().equals(newCineplexnameCineplex)){
                return true;
            }
        }
        return false;
    }

    public static int getCineplexIndex(ArrayList<Cineplex> cineplexList, String nameCineplex){
        String currentnameCineplex = "";
        for(int i = 0; i < cineplexList.size(); i++){
           currentnameCineplex = cineplexList.get(i).getName();
           if(currentnameCineplex.equals(nameCineplex)){
                return i;
           };
        }
        return -1;
    }

    public static void printCineplexList() throws ClassNotFoundException, IOException{
        ArrayList<Cineplex> cineplexList = getCineplexListFromFile();

        System.out.println();
        System.out.println("Printing out Cineplex List");
        for(Cineplex cineplex : cineplexList){
            System.out.println(cineplex.getName());
            System.out.println("-----------------");
            for(Cinema room : cineplex.getRoomList()){
                System.out.printf("ID: %s\n",room.getID());
            }
            System.out.println("");
        }
        System.out.printf("\n\n");

    }
    
    public static ArrayList<Cineplex> generateDummyData(){
        ArrayList<Cineplex> cineplexList = new ArrayList<>();
        Cinema cinema1,cinema2,cinema3;
        Movie movie1,movie2;

        Cineplex cineplex1 = new Cineplex("Cathay AMK Hub");
        cinema1 = new Cinema("AMK_001",ClassOfCinama.REGULAR);
        cinema2 = new Cinema("AMK_002",ClassOfCinama.DOLBY);
        cinema3 = new Cinema("AMK_003",ClassOfCinama.DOLBY);
        cineplex1.setRoom(cinema1);
        cineplex1.setRoom(cinema2);
        cineplex1.setRoom(cinema3);
        movie1 = new Movie("ONE PIECE FILM RED");
        movie2 = new Movie("Kong Fu Hustle");
        cineplex1.setMovie(movie1);
        cineplex1.setMovie(movie2);
        
        Cineplex cineplex2 = new Cineplex("Cathay Parkway Parade");
        cinema1 = new Cinema("PP_001",ClassOfCinama.REGULAR);
        cinema2 = new Cinema("PP_002",ClassOfCinama.DOLBY);
        cinema3 = new Cinema("PP_003",ClassOfCinama.DOLBY);
        cineplex2.setRoom(cinema1);
        cineplex2.setRoom(cinema2);
        cineplex2.setRoom(cinema3);

        Cineplex cineplex3 = new Cineplex("Cathay West Mall");
        cinema1 = new Cinema("WM_001",ClassOfCinama.REGULAR);
        cinema2 = new Cinema("WM_002",ClassOfCinama.DOLBY);
        cinema3 = new Cinema("WM_003",ClassOfCinama.DOLBY);
        cineplex3.setRoom(cinema1);
        cineplex3.setRoom(cinema2);
        cineplex3.setRoom(cinema3);
        
        cineplexList.add(cineplex1);
        cineplexList.add(cineplex2);
        cineplexList.add(cineplex3);
        
        return cineplexList;
    }

}