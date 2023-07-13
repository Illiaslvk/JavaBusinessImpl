package mp4.xor;

import mp2.Validation.NullValidation;
import mp3.MyException;
import mp4.ObjectPlus;

public class Ticket extends ObjectPlus {
    private long ticketId;
    private String place;
    private Client client;

    public Ticket(long ticketId, String place) {
        setTicketId(ticketId);
        setPlace(place);

        addToExtent();
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        if (ticketId <= 0) {
            throw new MyException("ticketId can not be negative");
        }
        this.ticketId = ticketId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        if (place == null) {
            throw new NullValidation("place can not be empty");
        }
        this.place = place;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client == null){
            throw new MyException("Client cannot be null!");
        }
        this.client = client;
    }

    @Override
    public void removeFromExtent() {
        this.client = null;
        super.removeFromExtent();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId = " + ticketId +
                ", place ='" + place + '\'' +
                '}';
    }

}
