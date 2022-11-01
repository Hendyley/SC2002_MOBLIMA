package MovieGoerModule;

public class Ticket {
    private int quantity;
    private AgeOfMovieGoer age;
    private TypeOfMovie movieType;
    private double price;
    private ClassOfCinama cinemaClass;

    public Ticket() {

    }

    public Ticket(int quantity, AgeOfMovieGoer age, TypeOfMovie movieType, ClassOfCinama cinemaClass) {
        this.quantity = quantity;
        this.age = age;
        this.movieType = movieType;
        this.cinemaClass = cinemaClass;
    }

    public double calcPrice() {

    }

}
