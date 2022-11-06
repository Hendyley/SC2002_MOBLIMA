package AdminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import MovieGoerModule.Cineplex;

public class testDB {
    private final static String Cineplex_FILE_NAME = "Cineplex.txt";

    public static ArrayList<Cineplex> getCineplexListFromFile() throws IOException, ClassNotFoundException{
        ArrayList<Cineplex> CineplexList = new ArrayList<Cineplex>();

        try{
            FileInputStream fileInputStream2 = new FileInputStream(Cineplex_FILE_NAME);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            CineplexList = (ArrayList<Cineplex>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Cineplex List retrieved from File");           
        }catch(FileNotFoundException e){
            FileOutputStream fileOutputStream = new FileOutputStream(Cineplex_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(CineplexList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Cineplex List File not found, creating new Cineplex List File");           
        }

        return CineplexList;
    }

    public static void addCineplexListToFile(ArrayList<Cineplex> CineplexList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(Cineplex_FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(CineplexList);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.printf("Cineplex Lists added to File\n");
    }

    public static boolean isExistingCineplex(ArrayList<Cineplex> CineplexList, String newCineplexnameCineplex){
        for(Cineplex cine: CineplexList){
            if(cine.getName().equals(newCineplexnameCineplex)){
                return true;
            }
        }
        return false;
    }

    public static int getCineplexIndex(ArrayList<Cineplex> CineplexList, String nameCineplex){
        String currentnameCineplex = "";
        for(int i = 0; i < CineplexList.size(); i++){
           currentnameCineplex = CineplexList.get(i).getName();
           if(currentnameCineplex.equals(nameCineplex)){
                return i;
           };
        }
        return -1;
    }

    public static void printCineplexList() throws ClassNotFoundException, IOException{
        ArrayList<Cineplex> CineplexList = getCineplexListFromFile();

        System.out.println();
        System.out.println("Printing out Cineplex List");
        for(Cineplex cine : CineplexList){
            cine.getName();
        }
        System.out.printf("\n\n");

    }
}
