package AdminModule;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import MovieGoerModule.Movie;
import MovieGoerModule.Status;
import MovieGoerModule.TypeOfMovie;

public class changeMovieApp {
    private final static String MOVIE_FILE_NAME = "Movie.txt";
    public changeMovieApp(){}

    private static ArrayList<Movie> getMovieListFromFile() throws IOException, ClassNotFoundException{
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        try{
            FileInputStream fileInputStream2 = new FileInputStream(MOVIE_FILE_NAME);
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            movieList = (ArrayList<Movie>) objectInputStream2.readObject();
            objectInputStream2.close();
            System.out.println("Movie List retrieved from File");           
        }catch(FileNotFoundException e){
            FileOutputStream fileOutputStream = new FileOutputStream(MOVIE_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(movieList);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Movie List File not found, creating new Movie List File");           
        }

        return movieList;
    }

    private static void addMovieListToFile(ArrayList<Movie> movieList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(MOVIE_FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(movieList);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.printf("Movie Lists added to File\n");
    }

    private static boolean isExistingMovie(ArrayList<Movie> movieList, String newMovieTitle){
        for(Movie m: movieList){
            if(m.getTitle().equals(newMovieTitle)){
                return true;
            }
        }
        return false;
    }

    private static int getMovieIndex(ArrayList<Movie> movieList, String title){
        String currentTitle = "";
        for(int i = 0; i < movieList.size(); i++){
           currentTitle = movieList.get(i).getTitle();
           if(currentTitle.equals(title)){
                return i;
           };
        }
        return -1;
    }

    private static void printMovieList() throws ClassNotFoundException, IOException{
        ArrayList<Movie> movieList = getMovieListFromFile();

        System.out.println();
        System.out.println("Printing out Movie List");
        for(Movie m : movieList){
            m.printDetails();
            System.out.printf("Ticket Sales: %s, ", m.getSales());
            System.out.printf("All Reviews: %s",m.getreviewlist());
            System.out.printf("All Time Slots: %s",m.getTimeSlots());
        }
        System.out.printf("\n\n");

    }



    public void createMovie() throws ClassNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of the movie:");
        String title = sc.nextLine();

        ArrayList<Movie> movieList = getMovieListFromFile();
        if(isExistingMovie(movieList,title)){
            System.out.println("Movie Title already existed");
            return;
        }

        Movie m = new Movie(title);

        System.out.println("Enter the type of movie");
        System.out.println("1: REGULAR_2D");
        System.out.println("2: REGULAR_3D");
        System.out.println("3: BLOCKBUSTER_2D");
        System.out.println("4: BLOCKBUSTER_3D");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                m.setType(TypeOfMovie.REGULAR_2D);
                break;

            case 2:
                m.setType(TypeOfMovie.REGULAR_3D);
                break;

            case 3:
                m.setType(TypeOfMovie.BLOCKBUSTER_2D);
                break;

            case 4:
                m.setType(TypeOfMovie.BLOCKBUSTER_3D);
                break;
        }
        //clear buffer
        sc.nextLine();

        System.out.println("Enter the director's name:");
        String director = sc.nextLine();
        m.setDirector(director);

        //do while loop for entering multiple cast
        System.out.println("Enter the cast: (0 to exit)");
        while(true){
            String cast = sc.nextLine();
            if(cast.equals("0")) break;
            m.addCast(cast);
        }

        System.out.println("Enter the status:");
        System.out.println("1: COMING_SOON ");
        System.out.println("2: PREVIEW");
        System.out.println("3: NOW_SHOWING");
        System.out.println("4: END_OF_SHOWING");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                m.setStatus(Status.COMING_SOON);
                break;

            case 2:
                m.setStatus(Status.PREVIEW);
                break;

            case 3:
                m.setStatus(Status.NOW_SHOWING);
                break;

            case 4:
                m.setStatus(Status.END_OF_SHOWING);
                break;
        }
        //clear buffer
        sc.nextLine();

        System.out.println("Enter the sypnosis:");
        String sypnosis = sc.nextLine();
        m.setSynopsis(sypnosis);

        //add time slots?

        movieList.add(m);
        addMovieListToFile(movieList);
        printMovieList();

        System.out.println("Movie successfully added!");
        m.printDetails();

    }

    public void updateMovie(String title) throws ClassNotFoundException, IOException{
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Movie> movieList;
        int index = -1;

        movieList = getMovieListFromFile();
        index = getMovieIndex(movieList,title);
        if(index < 0){
            System.out.println("Movie does not exist");
            return;
        }

        Movie m = movieList.get(index);
        System.out.println("original details:");
        m.printDetails();


        do{
            System.out.println("What would you like to change?");
            System.out.println("1: Status");
            System.out.println("2. Time slots");
            System.out.println("3: Done");
            choice = sc.nextInt();
                
            switch(choice){
                case 1:
                    System.out.println("Enter the status:");
                    System.out.println("1: COMING_SOON ");
                    System.out.println("2: PREVIEW");
                    System.out.println("3: NOW_SHOWING");
                    System.out.println("4: END_OF_SHOWING");
                    int set = sc.nextInt();
                    switch(set){
                        case 1:
                            m.setStatus(Status.COMING_SOON);
                            break;
            
                        case 2:
                            m.setStatus(Status.PREVIEW);
                            break;
            
                        case 3:
                            m.setStatus(Status.NOW_SHOWING);
                            break;
            
                        case 4:
                            m.setStatus(Status.END_OF_SHOWING);
                            break;
                    }
                    break;

                case 2:
                    //TIMESLOTS
                    break;

                case 3:
                    movieList.set(index,m);    
                    addMovieListToFile(movieList);
                    printMovieList();

                    System.out.println("Done!");
                    System.out.println("Updated details:");
                    m.printDetails();
                    break;
            }

        } while(choice != 3);
    }

    public void deleteMovie(String title) throws ClassNotFoundException, IOException{
        //delete movie from database?
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        ArrayList<Movie> movieList;
        int index = -1;

        movieList = getMovieListFromFile();
        index = getMovieIndex(movieList,title);
        if(index < 0){
            System.out.println("Movie does not exist");
            return;
        }

        Movie m = movieList.get(index);
        System.out.println("movie details:");
        m.printDetails();

        do{
            System.out.println("Confirm Delete?");
            System.out.println("1: YES ");
            System.out.println("2: NO ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    movieList.remove(index);
                    addMovieListToFile(movieList);
                    System.out.println("Movie successfully deleted!");
                    break;
                case 2:
                    System.out.println("Delete have been cancelled");
                    break;
                default:
                    break;
            }

        }while( !(choice == 1 || choice == 2));
        printMovieList();
    }

}
