package mp3.overlapping;

import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.*;
public class over {

    @Test
    public void test() {
        EnumSet<ClientType> clientTypes = EnumSet.of(ClientType.Employee, ClientType.Student, ClientType.Researcher);
        Client client = new Client(clientTypes, "John", 25, "1234567890", true,
                "john@example.com", "Apartment 1A", "Year 3", 123456789,
                "card for 2 year", "Computer Science");

        // Common properties
        assertEquals("John", client.getName());
        assertEquals(25, client.getAge());
        assertEquals("1234567890", client.getPhoneNumber());

        // Employee properties
        assertEquals("john@example.com", client.getEmail());
        assertEquals("Apartment 1A", client.getApartAddress());

        // Student properties
        assertEquals("Year 3", client.getYearOfStudy());
        assertEquals(123456789, client.getStudentID());

        // Researcher properties
        assertEquals("card for 2 year", client.getAffiliation());
        assertEquals("Computer Science", client.getResearchField());


    }
}