package mp3.abstractClass;

import mp3.BookGenre;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class abstractClass {

    @Test
    public void test(){
        List<Book> books = new ArrayList<>();

        BookForLearning bookForLearning = new BookForLearning(1,"s","s", BookGenre._Horror_,new Isbn("isbn",123456),"MAS",150,"Prof");
        LibrarySource librarySource = new LibrarySource(1,"o","o",BookGenre._Fantasy_,new Isbn("ISBN",6543121),"SMTH");

        books.add(bookForLearning);
        books.add(librarySource);

        librarySource.setReleaseName("First Release");
        assertEquals(13,librarySource.getReleaseName().length());

        assertTrue(bookForLearning.getLevelOfBook().contains("Prof"));
        assertTrue(bookForLearning.getSubjectCategory().contains("MAS"));

        assertEquals(0,librarySource.getReleaseNumber().size());

        LocalDate datePurchase = LocalDate.now();
        bookForLearning.addDatePurchase(datePurchase);

        String subject = bookForLearning.obtain("MAS");
        assertEquals("MAS", subject);

        String nonExistingSubject = bookForLearning.obtain("Non-existing Category");
        assertNull(nonExistingSubject);
    }
}