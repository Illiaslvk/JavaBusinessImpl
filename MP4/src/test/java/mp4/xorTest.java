package mp4;

import mp4.ordered.Book;
import mp4.unique.Employee;
import mp4.unique.Library;
import mp4.xor.Client;
import mp4.xor.PremiumTicket;
import mp4.xor.Ticket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class xorTest {
    @Test
    public void xorTest(){
        Client client = new Client(
                "John",19);

        PremiumTicket premiumTicket = new PremiumTicket(1,"A12","meeting with a star");
        Ticket ticket = new Ticket(1,"F23");

        client.setPremiumTicket(premiumTicket);


        assertNull(client.getTicket());
        assertNotNull(client.getPremiumTicket());
    }

}
