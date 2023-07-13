package mp4;

import mp4.Isbn;
import mp4.ordered.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class orderedTest {
    @Test
    public void test(){
        Book book1 = new Book(
                1,"Black Sea","sm", BookGenre._Fantasy_,new Isbn("bsasd",132212)
        );

        Book book2 = new Book(
                2,"Ace","sm", BookGenre._Fantasy_,new Isbn("a",654321)
        );

        Book book3 = new Book(
                3,"One piece","sm", BookGenre._Fantasy_,new Isbn("gvvd",123456)
        );

        // Get the list of books sorted by name
        List<Book> sortedBooks = Book.getBookByName();

        // Verify the order
        Assert.assertEquals(book2, sortedBooks.get(0));
        Assert.assertEquals(book1, sortedBooks.get(1));
        Assert.assertEquals(book3, sortedBooks.get(2));

    }
}
