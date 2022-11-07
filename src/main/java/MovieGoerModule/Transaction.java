package MovieGoerModule;

import java.io.Serializable;

public class Transaction implements Serializable{
    private String id;
    private String mgName;
    private String mgMobile;
    private String mgEmail;

    private Ticket[] tickets;

    public Transaction(String id, Ticket[] tickets) {
        this.id = id;
        this.tickets = tickets;
    }

    public Transaction(String id, String mgName, String mgMobile, String mgEmail, Ticket[] tickets) {
        this.id = id;
        this.mgName = mgName;
        this.mgMobile = mgMobile;
        this.mgEmail = mgEmail;
        this.tickets = tickets;
    }

    public String getId() {
        return this.id;
    }

    public String getMgName(){
        return this.mgName;
    }

    public String getMgMobile(){
        return this.mgMobile;
    }

    public String getMgEmail(){
        return this.mgEmail;
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
