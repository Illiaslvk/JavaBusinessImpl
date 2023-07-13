package mp4.xor;

import mp2.Validation.NullValidation;
import mp3.MyException;
import mp4.ObjectPlus;

import java.awt.datatransfer.MimeTypeParseException;

public class PremiumTicket extends ObjectPlus {
    private long ticketId;
    private String placeNearStage;
    private String bonus;
    private Client client;

    public PremiumTicket(long ticketId, String placeNearStage,String bonus) {
        setTicketId(ticketId);
        setPlaceNearStage(placeNearStage);
        setBonus(bonus);

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

    public String getPlaceNearStage() {
        return placeNearStage;
    }

    public void setPlaceNearStage(String placeNearStage) {
        if (placeNearStage == null) {
            throw new NullValidation("placeNearStage can not be empty");
        }
        this.placeNearStage = placeNearStage;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        if (bonus == null) {
            throw new NullValidation("bonus can not be empty");
        }
        this.bonus = bonus;
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
        return "PremiumTicket{" +
                "ticketId = " + ticketId +
                ", placeNearStage ='" + placeNearStage + '\'' +
                ", bonus='" + bonus + '\'' +
                '}';
    }
}
