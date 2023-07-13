package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class WithAttributeTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LibrarySourceRepository librarySourceRepository;

    @Autowired
    private LearningBookRepository learningBookRepository;

    @Test
    public void testCustomerReservationAssociation() {
        // Create a LibrarySource
        LibrarySource librarySource = LibrarySource.builder()
                .bookName("Library Book")
                .authorName("Author 1")
                .editionNumber(1)
                .build();

        // Create a LearningBook
        LearningBook learningBook = LearningBook.builder()
                .bookName("Learning Book")
                .authorName("Author 2")
                .subjectType(SubjectType.MAS)
                .pages(100)
                .build();

        // Save the LibrarySource and LearningBook
        librarySourceRepository.save(librarySource);
        learningBookRepository.save(learningBook);

        // Create a Customer
        Customer customer = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        // Create a Reservation and associate it with the LibrarySource and LearningBook
        Reservation reservation = Reservation.builder()
                .customer(customer)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(7))
                .books(Set.of(librarySource, learningBook))
                .build();

        // Save the Customer and Reservation
        customerRepository.save(customer);
        reservationRepository.save(reservation);

        // Retrieve the Customer and Reservation from the database
        Customer savedCustomer = customerRepository.findById(customer.getId()).orElse(null);
        Reservation savedReservation = reservationRepository.findById(reservation.getId()).orElse(null);

        // Assert the associations are correctly set
        assertNotNull(savedCustomer);
        assertNotNull(savedReservation);
        assertEquals("John", savedCustomer.getFirstName());
        assertEquals(LocalDate.now(), savedReservation.getStartDate());
        assertEquals(LocalDate.now().plusDays(7), savedReservation.getEndDate());
        assertTrue(savedReservation.getBooks().contains(learningBook));
        assertTrue(savedReservation.getBooks().contains(librarySource));

    }
}
