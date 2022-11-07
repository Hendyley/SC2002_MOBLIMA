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
            System.out.println(" Ticket "+id.substring(0,id.indexOf("Cinema"))+"age category: "+tickets[i].getAgetype()+" seat:"+tickets[i].getSeattype()+" price:"+tickets[i].getPrice()+" purchased:"+tickets[i].getDay()+" qty:"+tickets[i].getQuantity());
        }
    }


}
