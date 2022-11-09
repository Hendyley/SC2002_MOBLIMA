package AdminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import MovieGoerModule.AgeOfMovieGoer;
import MovieGoerModule.Cinema;
import MovieGoerModule.Cineplex;
import MovieGoerModule.ClassOfCinema;
import MovieGoerModule.Movie;
import MovieGoerModule.Seattype;
import MovieGoerModule.Status;
import MovieGoerModule.TimeSlot;
import MovieGoerModule.TypeOfMovie;

public class cineplexDB {
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

    public static boolean isExistingMovie(ArrayList<Movie> movieList, String newMovieTitle){
        for(Movie m: movieList){
            if(m.getTitle().equals(newMovieTitle)){
                return true;
            }
        }
        return false;
    }

    public static int getMovieIndex(ArrayList<Movie> movieList, String title){
        String currentTitle = "";
        for(int i = 0; i < movieList.size(); i++){
           currentTitle = movieList.get(i).getTitle();
           if(currentTitle.equals(title)){
                return i;
           };
        }
        return -1;
    }
    
    public static ArrayList<Cineplex> generateDummyData(){
        ArrayList<Cineplex> cineplexList = new ArrayList<>();
        Cinema cinema1,cinema2,cinema3;
        Movie movie1,movie2;
        String movieTitle;
        String director;
        ArrayList<String> cast;
        String synopsis;
        int movieDurationMin;
        TimeSlot timeslot1;
        TimeSlot timeslot2;
        

        Cineplex cineplex1 = new Cineplex("Cathay AMK Hub");
        cinema1 = new Cinema("AMK_001",ClassOfCinema.REGULAR);
        cinema2 = new Cinema("AMK_002",ClassOfCinema.DOLBY);
        cinema3 = new Cinema("AMK_003",ClassOfCinema.PLATINUM);
        //generate special seat
        cinema1 = getGenerateSpecialSeats(cinema1);
        cinema2 = getGenerateSpecialSeats(cinema2);
        cinema3 = getGenerateSpecialSeats(cinema3);
        cineplex1.setRoom(cinema1);
        cineplex1.setRoom(cinema2);
        cineplex1.setRoom(cinema3);
        //movie1
        movieTitle = "ONE PIECE FILM RED";
        director ="Goro Taniguchi";
        cast = new ArrayList<String>(Arrays.asList("Ikue Otani","Kaori Nazuka","Mayumi Tanaka"));
        synopsis = "Uta - the most beloved singer in the world.\n"
        +"Her voice, which she sings with while concealing her true identity\n";
        movieDurationMin = 115;
        movie1 = new Movie(movieTitle,director,cast,synopsis,Status.NOW_SHOWING
            ,TypeOfMovie.BLOCKBUSTER_2D,movieDurationMin,AgeOfMovieGoer.STUDENT);
        //movie2
        movieTitle = "Kung Fu Hustle";
        director ="Stephen Chow";
        cast = new ArrayList<String>(Arrays.asList("Stephen Chow","Danny Chan","Yuen Wah"));
        synopsis = "When the hapless Sing (Stephen Chow) and his dim-witted pal,\n"
         +"Bone (Feng Xiaogang), try to scam the residents of Pig Sty Alley\n";
        movieDurationMin = 98;
        movie2 = new Movie(movieTitle,director,cast,synopsis,Status.COMING_SOON
            ,TypeOfMovie.BLOCKBUSTER_2D, movieDurationMin,AgeOfMovieGoer.STUDENT);
        //timeslot1
        timeslot1 = new TimeSlot("11/12/2022","1600",cinema1,movie1.getTitle()
            ,movie1.getMovieDurationMin(),movie1.getType());
        //timeslot2
        timeslot2 = new TimeSlot("11/12/2022","1300",cinema3,movie2.getTitle()
            ,movie1.getMovieDurationMin(),movie1.getType());
        //settings
        movie1.addSlot(timeslot1);
        movie2.addSlot(timeslot2);
        cineplex1.addMovie(movie1);
        cineplex1.addMovie(movie2);
        
        Cineplex cineplex2 = new Cineplex("Cathay Parkway Parade");
        cinema1 = new Cinema("PP_001",ClassOfCinema.REGULAR);
        cinema2 = new Cinema("PP_002",ClassOfCinema.DOLBY);
        cinema3 = new Cinema("PP_003",ClassOfCinema.PLATINUM);
        //generate special seat
        cinema1 = getGenerateSpecialSeats(cinema1);
        cinema2 = getGenerateSpecialSeats(cinema2);
        cinema3 = getGenerateSpecialSeats(cinema3);
        cineplex2.setRoom(cinema1);
        cineplex2.setRoom(cinema2);
        cineplex2.setRoom(cinema3);

        Cineplex cineplex3 = new Cineplex("Cathay West Mall");
        cinema1 = new Cinema("WM_001",ClassOfCinema.REGULAR);
        cinema2 = new Cinema("WM_002",ClassOfCinema.DOLBY);
        cinema3 = new Cinema("WM_003",ClassOfCinema.PLATINUM);
        //generate special seat
        cinema1 = getGenerateSpecialSeats(cinema1);
        cinema2 = getGenerateSpecialSeats(cinema2);
        cinema3 = getGenerateSpecialSeats(cinema3);
        cineplex3.setRoom(cinema1);
        cineplex3.setRoom(cinema2);
        cineplex3.setRoom(cinema3);
        
        cineplexList.add(cineplex1);
        cineplexList.add(cineplex2);
        cineplexList.add(cineplex3);
        
        return cineplexList;
    }

    private static Cinema getGenerateSpecialSeats(Cinema roomstyle){
        roomstyle.setseattype(9,0,Seattype.COUPLE_SEAT);
        roomstyle.setseattype(9,2,Seattype.COUPLE_SEAT);
        roomstyle.setseattype(9,4,Seattype.COUPLE_SEAT);
        roomstyle.setseattype(9,6,Seattype.COUPLE_SEAT);

        roomstyle.setseattype(8,0,Seattype.ELITE_SEAT);
        roomstyle.setseattype(8,2,Seattype.ELITE_SEAT);

        roomstyle.setseattype(8,4,Seattype.ULTIMA_SEAT);
        roomstyle.setseattype(8,6,Seattype.ULTIMA_SEAT);
        
        return roomstyle;
    }

}
