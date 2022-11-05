package MovieGoerModule;

import java.util.ArrayList;

public class Ticket {
    private int quantity;
    private AgeOfMovieGoer age;
    private TypeOfMovie movieType;
    private double price;
    private ClassOfCinama cinemaClass;
    private Day day;


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

        // switch case give the output of usual adult prices with diff days;
        switch (day) {
            case REMAINING_DAYS:
                if (movieType == TypeOfMovie.REGULAR_2D) {
                    price = 11;
                }

                if (movieType == TypeOfMovie.REGULAR_3D) {
                    price = 15;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_2D) {
                    price = 15;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_3D) {
                    price = 20;
                }
                break;
            case MON_TO_WED:
                if (movieType == TypeOfMovie.REGULAR_2D) {
                    price = 8.5;
                }

                if (movieType == TypeOfMovie.REGULAR_3D) {
                    price = 11;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_2D) {
                    price = 11;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_3D) {
                    price = 16;
                }
                break;

            case THURS:
                if (movieType == TypeOfMovie.REGULAR_2D) {
                    price = 9.5;
                }

                if (movieType == TypeOfMovie.REGULAR_3D) {
                    price = 11;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_2D) {
                    price = 11;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_3D) {
                    price = 16;
                }
                break;

            case FRI_BEFORE_6:
                if (movieType == TypeOfMovie.REGULAR_2D) {
                    price = 9.5;
                }

                if (movieType == TypeOfMovie.REGULAR_3D) {
                    price = 15;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_2D) {
                    price = 15;
                }

                if (movieType == TypeOfMovie.BLOCKBUSTER_3D) {
                    price = 20;
                }

            default:
                price = 11;
        }

        // student prices
        if (age == AgeOfMovieGoer.STUDENT && day != Day.REMAINING_DAYS) {
            if (movieType == TypeOfMovie.REGULAR_2D) {
                price = 7;
            }

            if (movieType == TypeOfMovie.REGULAR_3D) {
                price = 9;
            }

            if (movieType == TypeOfMovie.BLOCKBUSTER_2D) {
                price = 9;
            }

            if (movieType == TypeOfMovie.BLOCKBUSTER_3D) {
                price = 11;
            }
        }

        // SENIOR prices
        if (age == AgeOfMovieGoer.SENIOR && day != Day.REMAINING_DAYS) {
            if (movieType == TypeOfMovie.REGULAR_2D) {
                price = 4;
            }
        }

        // CHILD prices
        if (age == AgeOfMovieGoer.STUDENT && day != Day.REMAINING_DAYS) {
            if (movieType == TypeOfMovie.REGULAR_2D) {
                price = 5;
            }

            if (movieType == TypeOfMovie.REGULAR_3D) {
                price = 7;
            }

            if (movieType == TypeOfMovie.BLOCKBUSTER_2D) {
                price = 7;
            }

            if (movieType == TypeOfMovie.BLOCKBUSTER_3D) {
                price = 7;
            }
        }

        // just add final constant price value of cinema class
        if (cinemaClass == ClassOfCinama.PLATINUM) {
            price += 10;
        }

        if (cinemaClass == ClassOfCinama.DOLBY) {
            price += 5;
        }

        return price * quantity;
    }

    public double getPrice() {
        return price;
    }
    public AgeOfMovieGoer get(){
        return age;
    }

    public TypeOfMovie getMovieType(){
        return movieType;
    }

    public Day getDay(){
        return day;
    }
    public ClassOfCinama getCinemaClass(){
        return cinemaClass;
    }

    public int getQuantity(){
        return quantity;
    }


}
