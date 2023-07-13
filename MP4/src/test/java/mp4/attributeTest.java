package mp4;


import mp4.attribute.Customer;
import mp4.attribute.Book;
import mp4.attribute.Isbn;
import org.junit.Assert;
import org.junit.Test;

public class attributeTest {
    @Test
    public void test(){
        Book book = new Book(1,"s","s",BookGenre._Horror_,new Isbn("s",123123));
        Customer customer = new Customer("ok","s");



    }
}
