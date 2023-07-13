package mp2.Qualified;

//Qualified

import mp2.Book;
import mp2.Validation.BookValidation;
import mp2.Validation.NullValidation;

import java.time.LocalTime;
import java.util.*;

public class BookRestoration {

    private int restorationPrice;
    private int hours;
    private int minutes;
    private LocalTime timeInSecond = LocalTime.of(hours,minutes);

    private final Map<Integer, Book> books = new HashMap<>();

    public BookRestoration(int restorationPrice, LocalTime timeInSecond) {
        setRestorationPrice(restorationPrice);
        setTimeInSecond(timeInSecond);
    }

    // Restoration price
    public int getRestorationPrice() {
        return restorationPrice;
    }

    public void setRestorationPrice(int restorationPrice) {
        if(restorationPrice != 20) {
            throw new BookValidation("Price must have value 20!!!");
        }
        this.restorationPrice = restorationPrice;
    }

    // Time
    public LocalTime getTimeInSecond() {
        return timeInSecond;
    }

    public void setTimeInSecond(LocalTime timeInSecond) {
        if(timeInSecond == null) {
            throw new NullValidation("Time cannot be null!");
        }
        this.timeInSecond = timeInSecond;
    }

    // Map Books

    public Map<Integer, Book> getBooks() {
        return Collections.unmodifiableMap(books);
    }

    public List<Book> getBookList() {
        return new ArrayList<>(books.values());
    }

    public void addBookRestoration(Book book) {
        if (book == null) {
            throw new NullValidation("Book cannot be null");
        }
        if (books.containsKey(book.getIdBook())) {
            if (books.get(book.getIdBook()) != book) {
                throw new BookValidation("Book with the same id already exists/or did not exist");
            }
            return;
        }
        books.put(book.getIdBook(), book);
        book.setBookRestoration(this);
    }

    public void removeBookRestoration(Book book) {
        if (book == null) {
            throw new NullValidation("Book cannot be null!!!");
        }
        if (!books.containsKey(book.getIdBook())) { // <-- Check if book exists in map
            throw new BookValidation("Book with ID " + book.getIdBook() + " does not exist in the restoration list");
        }
        if (books.remove(book.getIdBook(), book)) {
            book.setBookRestoration(null);
        }
    }


}
