package AdminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import MovieGoerModule.Cineplex;

import AdminModule.cinexplexDB;


public class testCineplexApp {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // ArrayList<Cineplex> CineplexList = cinexplexDB.getCineplexListFromFile();
        cinexplexDB.printCineplexList();
    }
}
