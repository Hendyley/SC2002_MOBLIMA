package AdminModule;
import java.util.Scanner;
import MovieGoerModule.Movie;
import MovieGoerModule.Status;
import MovieGoerModule.TypeOfMovie;

public class changeMovieApp {

    public changeMovieApp(){}

    public void createMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of the movie:");
        String title = sc.nextLine();
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

        System.out.println("Enter the director's name:");
        String director = sc.nextLine();
        m.setDirector(director);

        //do while loop for entering multiple cast
        System.out.println("Enter the cast: (0 to exit)");
        while(true){
            String cast = sc.nextLine();
            m.addCast(cast);
            if(cast.equals("0")) break;
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

        System.out.println("Enter the sypnosis:");
        String sypnosis = sc.nextLine();
        m.setSynopsis(sypnosis);

        //add time slots?

        System.out.println("Movie successfully added!");
        m.printDetails();

    }

    public void updateMovie(Movie m){
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("What would you like to change?");
            System.out.println("1: Status");
            System.out.println("2. Time slots");
            System.out.println("3: Done");

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
                    System.out.println("Done!");
                    System.out.println("Updated details:");
                    m.printDetails();
                    break;
            }

        } while(choice != 3);

    }

    public void deleteMovie(Movie m){
        //delete movie from database?
    }

}
