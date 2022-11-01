package MovieGoerModule;

public class Ticket {
    private int quantity;
    private AgeOfMovieGoer age;
    private TypeOfMovie movieType;
    private double price;
    private ClassOfCinama cinemaClass;
    private Day day;

    private double[][][][] priceList = new double[4][4][4][4];

    public Ticket() {

    }

    public Ticket(int quantity, AgeOfMovieGoer age, TypeOfMovie movieType, ClassOfCinama cinemaClass, Day day) {
        this.quantity = quantity;
        this.age = age;
        this.movieType = movieType;
        this.cinemaClass = cinemaClass;
        this.day = day;
    }

    public double calcPrice() {
        price = priceList[age.ordinal()][movieType.ordinal()][cinemaClass.ordinal()][day.ordinal()];
        return price * quantity;
    }

}
