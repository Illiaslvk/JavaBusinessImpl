package mp4;

import mp4.busConstraint.Book;
import mp4.busConstraint.LimitReservation;
import mp4.busConstraint.Reservation;
import org.junit.Test;

import java.time.LocalDate;

public class businessConstraintTest {
    @Test
    public void test(){
        Book book = new Book(1,"s","s",BookGenre._Horror_,new Isbn("1",123123),500,"sd");
        Reservation reservation = new Reservation(LocalDate.of(2023,4,16),LocalDate.of(2023,5,17),3,2);

        LimitReservation limitReservation = new LimitReservation(3,5,reservation,book);

        LimitReservation limitReservation1 = new LimitReservation(2,4,reservation,book);

    }
}
