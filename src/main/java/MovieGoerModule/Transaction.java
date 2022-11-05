package MovieGoerModule;

public class Transaction {
    private String id;

    private Ticket[] tickets;

    public Transaction(String id, Ticket[] tickets) {
        this.id = id;
        this.tickets = tickets;
    }

    public String getId() {
        return this.id;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void printTickets() {
        for (int i = 0; i < tickets.length; i++) {
            System.out.println(" Ticket "+id+" qty:"+tickets[i].getQuantity()+" price:"+tickets[i].getPrice()+" purchased:"+tickets[i].getDay()
                    +" cinema class:"+tickets[i].getCinemaClass()+" movie type:"+tickets[i].getMovieType() );
        }
    }


}
