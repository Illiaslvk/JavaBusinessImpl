package mp1;

import mp1.Enum.BookGenre;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(
                1,
                "One piece",
                "Eiichiro Oda",
                BookGenre._History_,
                new Isbn("ISBN",123456),
                500,
                "Yuuji Iwasakai",
                null,
                LocalDate.of(1999,9,19)
        );
        Book book2 = new Book(
                2,
                "Fire Force",
                "Stiven King",
                BookGenre._Sexology_,
                new Isbn("ISBN",1234575),
                360,
                "Kodansha Comics",
                //LocalDate.of(2222,2,22),
                LocalDate.of(2016, 2, 17),
                LocalDate.of(2000, 12, 12)
        );

        Book book3 = new Book(
                3,
                "Business Partner",
                "Ada Wong",
                BookGenre._Study_,
                new Isbn("ISBN",12345565),
                100,
                "Pearson",
                //year of writing
                LocalDate.of(2020, 4, 24),
                //datePurchase
                LocalDate.of(2016,2,17)
        );
        //book
        //working test
        book1.setAuthorBook("someone");
        System.out.println("New author: " + book1.getAuthorBook());

        book1.setBookGenre(BookGenre._Fantasy_);
        System.out.println("New genre: " + book1.getBookGenre());

        book1.setIsbnNumber(new Isbn("ISBN",1543535455));
        System.out.println("New ISBN: " + book1.getIsbnNumber());

        //purchase
        book3.addDatePurchase((LocalDate.of(2016,03,20)));
        //book3.removeDatePurchase((LocalDate.of(1999,5,15)));
        List<LocalDate> purchaseDates = book3.getDatePurchase();
        System.out.println("///////////////////Purchase Date///////////////////////");
        System.out.println("Purchase dates for " + book3.getNameBook() + ":");
        for (LocalDate date : purchaseDates) {
            System.out.println(date);
        }

        //Method
        System.out.println("///////////////////Find Book By Author////////////////////");
        List<Book> bookList = Book.findBookByAuthor("someone");
        if (!bookList.isEmpty()) {
            System.out.println("Found book: " + bookList);
        } else {
            System.out.println("We don't have book with this author");
        }
        System.out.println("/////////////////////Extent//////////////////");

        //method for saving extent data into a file
        Book.saveExtent();
        //method for loading extent data from a file
        Book.loadExtent();
    }
}
