package mp4.bag;

import mp4.BookGenre;
import mp4.BookValidation;
import mp4.Isbn;
import mp4.NullValidation;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Book implements Serializable {

    private static final String DATA_DIR_PATH = "./src/main/java/mp2/data/";
    private static final String DATA_FILE_NAME = "Book";
    private static List<Book> extent = new ArrayList<>();

    private int idBook;
    private String nameBook;
    private String authorBook;
    private BookGenre bookGenre;
    private Isbn isbnNumber; // complex
    private float price; //derived with discount
    public static int minPrice = 10; // class
    private String edition;
    private LocalDate yearWriting;//optional
    private final List<LocalDate> datePurchase = new ArrayList<>(); //multi-value

    //Associations
    private final Set<Purchase> purchases = new HashSet<>(); // With an attribute many-to-many

    public Book(int idBook, String nameBook, String authorBook, BookGenre bookGenre, Isbn isbnNumber , float price, String edition, LocalDate yearWriting) {
        setIdBook(idBook);
        setNameBook(nameBook);
        setAuthorBook(authorBook);
        setBookGenre(bookGenre);
        setIsbnNumber(isbnNumber);
        setPrice(price);
        setEdition(edition);
        setYearWriting(yearWriting);
        extent.add(this);
    }

    public Book(int idBook, String nameBook, String authorBook, BookGenre bookGenre, Isbn isbnNumber , float price, String edition) {
        setIdBook(idBook);
        setNameBook(nameBook);
        setAuthorBook(authorBook);
        setBookGenre(bookGenre);
        setIsbnNumber(isbnNumber);
        setPrice(price);
        setEdition(edition);
        setYearWriting(null);
        extent.add(this);
    }

    public Book(int idBook, String nameBook, String authorBook, BookGenre bookGenre, Isbn isbnNumber, float price, String edition, LocalDate yearWriting, LocalDate datePurchase) {
        setIdBook(idBook);
        setNameBook(nameBook);
        setAuthorBook(authorBook);
        setBookGenre(bookGenre);
        setIsbnNumber(isbnNumber);
        setPrice(price);
        setEdition(edition);
        setYearWriting(yearWriting);
        addDatePurchase(datePurchase);
        extent.add(this);
    }

 ////////////////////Getters and Setters////////////////////

 //Name Book
    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        if(nameBook == null || nameBook.isBlank()) {
            throw new NullValidation("Name of the book cannot be null!!!");
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

    private void setIdBook(int idBook) {
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

    //Price of the book

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price < minPrice) {
            throw new BookValidation("Book cannot has value smaller than 10");
        }
        this.price = price;
    }

    public float getPriceWithDiscount() {
        if (price > 350) {
            double discount = price * 0.05;
            return price - (float)discount;
        }
        else
            return price;
    }

    //Book edition


    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        if(edition == null | edition.isBlank()) {
            throw new NullValidation("Value of edition cannot be null");
        }
        this.edition = edition;
    }

    // Year of writing book

    public LocalDate getYearWriting() {
        return yearWriting;
    }

    public void setYearWriting(LocalDate yearWriting) {
        this.yearWriting = yearWriting;
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
            throw new NullValidation("Date cannot be null!!");
        } else if (datePurchase.isAfter(LocalDate.now())) {
            throw new BookValidation("Date cannot be in future");
        }
        this.datePurchase.add(datePurchase);
    }

    public void removeDatePurchase(LocalDate datePurchase) {
        this.datePurchase.remove(datePurchase);
    }


    // WAA Many-to-many
    public Set<Purchase> getPurchases() {
        return Collections.unmodifiableSet(purchases);
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


    //METHOD
    //Find book by Author

    public static List<Book> findBookByAuthor(String autorBook) {
        if(autorBook == null | autorBook.isBlank()) {
            throw new NullValidation("Author Name cannot be null!!!!!");
        }
        //Use the stream() method to convert the List<Book> object extent to a stream of Book objects.
        return extent.stream()
                //Use the filter() method on the stream to filter only the Book objects whose author name matches the authorBook parameter.
                .filter(a -> a.getAuthorBook()
                        //Use the collect() method with the Collectors.toList() method to collect the filtered Book objects into a new List<Book> object.
                        .equals(autorBook)).collect(Collectors.toList());
    }

    //Extents
    public static List<Book> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void setExtent(List<Book> extent) {
        Book.extent = extent;
    }

    public static void saveExtent() {
        File file = new File(DATA_DIR_PATH);
        file.mkdir();
        file = new File(DATA_DIR_PATH+DATA_FILE_NAME);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(extent);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadExtent(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_DIR_PATH + DATA_FILE_NAME)))
        {
            extent = (List<Book>)ois.readObject();
            System.out.println(extent);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
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
                "price = " + price + '\n'+
                "price with discount = " + getPriceWithDiscount() + '\n' +
                "edition = " + edition + '\n' +
                "yearWriting = " + (yearWriting!=null?yearWriting:" ") + '\n' +
                "from18Years = " + getFrom18Years() + '\n' +
                "datePurchase = " + datePurchase + '\n' +
                '}';
    }
}
