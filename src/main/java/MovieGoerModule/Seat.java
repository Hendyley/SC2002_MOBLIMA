package test.src;

public class Seat {
    private boolean seat;

    public Seat(){
        this.seat = false;
    }

    public boolean isTaken(){
        return seat;
    }

    public void bookSeat(){
        this.seat = true;
    }
}
