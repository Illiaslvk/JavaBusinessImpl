package mp2;

import mp2.Basic.BookForLearning;
import mp2.Composition.Opinion;
import mp2.Enum.BookGenre;
import mp2.Qualified.BookRestoration;
import mp2.WithAnAttributeManyToMany.Customer;
import mp2.WithAnAttributeManyToMany.Purchase;
import mp2.WAAOneToMany.LimitReservation;
import mp2.WAAOneToMany.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
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
                LocalDate.of(1999, 12, 24)
        );
        Book book2 = new Book(
                2,
                "Fire Force",
                "Stiven King",
                BookGenre._Sexology_,
                new Isbn("ISBN",1234575),
                370,
                "Kodansha Comics",
                LocalDate.of(2016, 2, 17)
        );

        Book book3 = new Book(
                3,
                "Business Partner",
                "Ada Wong",
                BookGenre._Study_,
                new Isbn("ISBN",12345565),
                110,
                "Pearson",
                //year of writing
                LocalDate.of(2020, 4, 24),
                //datePurchase
                LocalDate.of(2016,2,17)
        );
        Book book4 = new Book(
                4,
                "IPB",
                "Someone",
                BookGenre._Study_,
                new Isbn("ISBN",12342365),
                110,
                "MB",
                //year of writing
                LocalDate.of(2020, 4, 24),
                //datePurchase
                LocalDate.of(2016,2,17)
        );
        //book
        //working test
        book1.setAuthorBook("Illia Solovko");
        System.out.println(book1.getAuthorBook());

        book1.setBookGenre(BookGenre._Fantasy_);
        System.out.println(book1.getBookGenre());

        book1.setIsbnNumber(new Isbn("ISBN",1543535455));
        System.out.println(book1.getIsbnNumber());

        //purchase
        book3.addDatePurchase((LocalDate.of(1999,5,15)));
        //book3.removeDatePurchase((LocalDate.of(1999,5,15)));
        List<LocalDate> purchaseDates = book3.getDatePurchase();
        System.out.println("//////////////////////////////////////////");
        System.out.println("Purchase dates for " + book3.getNameBook() + ":");
        for (LocalDate date : purchaseDates) {
            System.out.println(date);
        }

        //Method
        System.out.println("///////////////////////////////////////");
        List<Book> bookList = Book.findBookByAuthor("Illia Solovko");
        if (!bookList.isEmpty()) {
            System.out.println("This books you can find " + bookList);
        } else {
            System.out.println("We don't have book of this author :(");
        }

        System.out.println("////////////////////Composition test///////////////////");
        //Composition test
        Opinion opinion1 = Opinion.createOpinion(4, "Cool", book1);
        Opinion opinion2 = Opinion.createOpinion(3, "mid", book2);
        book2.removeOpinion(opinion2);

        System.out.println("Opinions for Book 1:");
        System.out.println(book1.getOpinions());

        System.out.println("Opinions for Book 2:");
        System.out.println(book2.getOpinions());

        System.out.println("////////////////////Basic test///////////////////");
        //Test Basic
        BookForLearning bookForLearning = new BookForLearning("MAS", 300, "Advanced");
        bookForLearning.addBookForLearning(book4);

        System.out.println("Book for learning: " + bookForLearning);
        System.out.println("Level of Book: " + bookForLearning.getLevelOfBook());
        //for-each loop
        for (Book relatedBook : bookForLearning.getRelatedBooks()) {
            System.out.println("Related books: " + relatedBook.getNameBook());
        }

        bookForLearning.addBookForLearning(book3);
        bookForLearning.removeBookForLearning(book4);
        for (Book relatedBook : bookForLearning.getRelatedBooks()) {
            System.out.println("Related books: " + relatedBook.getNameBook());
        }

        System.out.println("////////////////////Qualified test////////////////");
        //Test qualified association
        BookRestoration bookRestoration = new BookRestoration(20, LocalTime.of(12, 0));

        bookRestoration.addBookRestoration(book1);
        bookRestoration.addBookRestoration(book2);
        System.out.println("Restoration price: " + bookRestoration.getRestorationPrice());
        System.out.println("Time in seconds: " + bookRestoration.getTimeInSecond());
        System.out.println("Books for restoration: \n" + bookRestoration.getBooks());

        bookRestoration.removeBookRestoration(book2);

        System.out.println("\n Books for restoration: " + bookRestoration.getBooks());


        System.out.println("////////////////////Association test O-T-M///////////////");
        //Test association with attributes one-to-many
        Reservation reservation1 = new Reservation(LocalDate.of(2022,5,1),LocalDate.of(2024,5,1),3,2);
        LimitReservation limit1 = new LimitReservation(0, 5, reservation1, book1);

        System.out.println("Max book reserved: " + limit1.getMaxBookReserved());
        System.out.println("Number of times book reserved: " + limit1.getHowManyTimeBookReserved());

        limit1.setMaxBookReserved(10);
        limit1.setHowManyTimeBookReserved(2);

        System.out.println("Max book reserved: " + limit1.getMaxBookReserved());
        System.out.println("Number of times book reserved: " + limit1.getHowManyTimeBookReserved());

        reservation1.addLimitReservation(limit1);
        reservation1.removeLimitReservation(limit1);

        if (reservation1.getLimitReservations().contains(limit1)) {
            System.out.println("Limit reservation was added");
        } else {
            System.out.println("Failed to add limit");
        }

        System.out.println("////////////////////Association test M-T-M///////////////");
        //Test association with attributes many-to-many
        Customer customer1 = new Customer("John","Someone");
        Purchase purchase1 = new Purchase(LocalDate.of(2023, 5, 2),100,customer1,book1);
        System.out.println(purchase1);
        System.out.println(customer1);
        purchase1.remove();
        System.out.println(purchase1);
        System.out.println(customer1);
    }
}
