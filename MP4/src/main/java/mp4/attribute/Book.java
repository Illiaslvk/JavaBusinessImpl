package mp4.attribute;

import mp4.BookGenre;
import mp4.NullValidation;
import mp4.BookValidation;

import java.time.LocalDate;
import java.util.*;

public class Book {

    private int idBook;
    private String nameBook;
    private String authorBook;
    private BookGenre bookGenre;
    private Isbn isbnNumber;
    private double price;
    public static int minPrice = 10;
    private final List<LocalDate> datePurchase = new ArrayList<>();
    private final Set<Purchase> purchases = new HashSet<>(); // With an attribute many-to-many

    public Book(int idBook, String nameBook, String authorBook, BookGenre bookGenre, Isbn isbnNumber) {
        setIdBook(idBook);
        setNameBook(nameBook);
        setAuthorBook(authorBook);
        setBookGenre(bookGenre);
        setIsbnNumber(isbnNumber);
    }
    public Book(int idBook, String nameBook, String authorBook, BookGenre bookGenre, Isbn isbnNumber, LocalDate datePurchase) {
        setIdBook(idBook);
        setNameBook(nameBook);
        setAuthorBook(authorBook);
        setBookGenre(bookGenre);
        setIsbnNumber(isbnNumber);
        addDatePurchase(datePurchase);
    }

 ////////////////////Getters and Setters////////////////////

 //Name Book
    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        if(nameBook == null || nameBook.isBlank()) {
            throw new NullValidation("Name of the book cannot be null!!!!!!!!!");
        }
        this.nameBook = nameBook;
    }

    //BookGenre

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        if(bookGenre == null) {
            throw new NullValidation("Genre of the book cannot be null!!!!!!");
        }
        this.bookGenre = bookGenre;
    }

    //Isbn - International Standard Book Number
    public Isbn getIsbnNumber() {
        return isbnNumber;
    }
    public void setIsbnNumber(Isbn isbnNumber) {
        if(isbnNumber == null) {
            throw new NullValidation("ISBN cannot be null!!");
        } else if(String.valueOf(isbnNumber.getUniqueNumber()).length() < 6) {
            throw new BookValidation("Too short uniqueNumber!!");
        } else if (isbnNumber.getIsbn() == null) {
            throw new NullValidation("ISBN cannot be null!!");
        }
        this.isbnNumber = isbnNumber;
    }

    //Book ID
    public int getIdBook() {
        return idBook;
    }
    public void setIdBook(int idBook) {
        if(idBook < 0) {
            throw new BookValidation("Id cannot be smaller than 0");
        }
        this.idBook = idBook;
    }

    //Author Book

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        if(authorBook == null) {
            throw new NullValidation("Value of author cannot be null");
        }
        this.authorBook = authorBook;
    }

    // From 18 years
    public boolean getFrom18Years() {
        if(bookGenre == BookGenre._Sexology_) {
            return true;
        }
        return false;
    }

    //Date of purchase

    public List<LocalDate> getDatePurchase() {
        return Collections.unmodifiableList(datePurchase);
    }

    public void addDatePurchase(LocalDate datePurchase) {
        if(datePurchase == null) {
            throw new IllegalArgumentException("Date cannot be null!!");
        } else if (datePurchase.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be in future");
        }
        this.datePurchase.add(datePurchase);
    }

    public void removeDatePurchase(Date datePurchase) {
        this.datePurchase.remove(datePurchase);
    }

    public void addPurchases(Purchase purchase) {
        if (purchase == null) {
            throw new IllegalArgumentException("The purchase argument cannot be null.");
        }

        if (!purchases.contains(purchase)) {
            this.purchases.add(purchase);
        }
    }
    public void removePurchases(Purchase purchase) {
        if (purchase == null) {
            throw new IllegalArgumentException("The purchase argument cannot be null.");
        }

        if (this.purchases.contains(purchase)) {
            this.purchases.remove(purchase);
            purchase.remove();
        }
    }

    public double getPrice() {
        return price;
    }

    // dynamic
    public void setPrice(double price) {
        double maxAllowedIncrease = this.price / 10; // Allowing a maximum increase of 10%
        double maxPrice = this.price + maxAllowedIncrease;

        if (price < minPrice) {
            throw new BookValidation("Book price cannot be smaller than 10");
        } else if (price > maxPrice) {
            throw new BookValidation("Price can not be increased by more than 10%");
        }

        this.price = price;
    }


    //OverRiding
    @Override
    public String toString() {
        return "\n Book {" + '\n' +
                "idBook = " + idBook + '\n' +
                "nameBook = " + nameBook + '\n' +
                "authorBook = " + authorBook + '\n' +
                "bookGenre = " + bookGenre + '\n'+
                "isbn number = " + isbnNumber + '\n' +
                "from18Years = " + getFrom18Years() + '\n' +
                "datePurchase = " + datePurchase + '\n' +
                '}';
    }

}