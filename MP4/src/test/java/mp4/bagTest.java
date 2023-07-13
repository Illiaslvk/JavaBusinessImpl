package mp4;

import mp4.bag.Book;
import mp4.bag.Customer;
import mp4.bag.Purchase;
import org.junit.Test;

import java.time.LocalDate;

public class bagTest {
    @Test
    public void test(){
        Book book = new Book(1,"s","s",BookGenre._Horror_,new Isbn("1",123123),500,"sd");
        Customer customer = new Customer("as","asd");

        Purchase purchase = new Purchase(LocalDate.of(2020,1,1),124,customer,book);

        Purchase purchase2 = new Purchase(LocalDate.of(2021,1,1),51,customer,book);

    }
}
