package MovieGoerModule;

public class Seat {
    private boolean seat;

    private Seattype seattype;

    public Seat() {
        this.seat = false;
    }

    public boolean isTaken() {
        return seat;
    }

    public void bookSeat() {
        this.seat = true;
    }

    private void setSeattype(Seattype seattype){
        this.seattype = seattype;
    }
    public Seattype getSeattype(){
        return seattype;
    }
}
