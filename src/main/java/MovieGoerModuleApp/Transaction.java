package MovieGoerModuleApp;

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
            System.out.println("Ticket");
        }
    }
}
