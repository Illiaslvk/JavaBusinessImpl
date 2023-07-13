package mp3.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class dynam {

    @Test
    public void test() {
        Client clientE = new Client(ClientType.Employee, "John", 30, "1234567890",
                false, "john@example.com", "123 Main St", null, null);

        Client clientS = new Client(ClientType.Student, "Jane", 20, "9876543210",
                false, null, null, "6", 54321);

        clientS.setName("Max");
        assertEquals("Max", clientS.getName());

        clientE.becomeStudent("3", 12345);
        assertEquals(ClientType.Student, clientE.getClientTypes());
        assertEquals("3", clientE.getYearOfStudy());
        assertEquals(Integer.valueOf(12345), clientE.getStudentID());

        clientS.becomeEmployee("xxx@example.com", "Main St");
        assertEquals(ClientType.Employee, clientS.getClientTypes());
        assertEquals("xxx@example.com", clientS.getEmail());
        assertEquals("Main St", clientS.getApartAddress());

    }

}