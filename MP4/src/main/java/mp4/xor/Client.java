package mp4.xor;

import mp3.BookValidation;
import mp3.MyException;
import mp3.NullValidation;
import mp4.ObjectPlus;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Client extends ObjectPlus {
    private String firstName;
    private int age;

    //XOR
    private PremiumTicket premiumTicket;
    private Ticket ticket;

    public Client(String firstName, int age) {
        setFirstName(firstName);
        setAge(age);

        addToExtent();
    }

    public String getFirstName() {
        return firstName;
    }
    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isBlank()){
            throw new NullValidation("firstName cannot be null!!!");
        }
        this.firstName = firstName;
    }

    public void setAge(int age) {
        if((Integer)age == null) {
            throw new NullValidation("Age cannot be null!!!");
        } else if(age < 18) {
            throw new MyException("Client too young!");
        }
        this.age = age;
    }

    public PremiumTicket getPremiumTicket() {
        return premiumTicket;
    }

    public void setPremiumTicket(PremiumTicket premiumTicket) {
        if (ticket != null) {
            throw new MyException("Cannot set a premium ticket when the client already has a regular ticket!");
        }
        if (premiumTicket == null) {
            throw new MyException("Premium ticket cannot be null. Please remove the existing one in this case.");
        }
        if (this.premiumTicket == premiumTicket) {
            return;
        }
        if (this.premiumTicket != null) {
            this.premiumTicket.removeFromExtent();
        }
        this.premiumTicket = premiumTicket;
    }

    public void removePremiumTicket() {
        if (ticket != null) {
            throw new MyException("Cannot remove a premium ticket. XOR constraint.");
        }
        if (premiumTicket == null) {
            throw new IllegalArgumentException("Client does not have a premium ticket to remove!");
        }
        premiumTicket.removeFromExtent();
        premiumTicket = null;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        if (premiumTicket != null) {
            throw new MyException("Cannot set a regular ticket when the client already has a premium ticket!");
        }
        if (ticket == null) {
            throw new MyException("Ticket cannot be null!");
        }
        if (ticket.getClient() != this){
            throw new MyException("ticket does not refer to this client");
        }
        if (this.ticket != null) {
            this.ticket.removeFromExtent();
        }
        this.ticket = ticket;
    }

    public void removeTicket() {
        if(ticket != null && premiumTicket == null){
            ticket.removeFromExtent();
            ticket = null;
        }
    }

    @Override
    public void removeFromExtent() {
        super.removeFromExtent();
        if (ticket != null) {
            ticket.removeFromExtent();
            ticket = null;
        }
        if (premiumTicket != null) {
            premiumTicket.removeFromExtent();
            premiumTicket = null;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName = " + firstName +
                ", age ='" + age + '\'' +
                '}';
    }
}
