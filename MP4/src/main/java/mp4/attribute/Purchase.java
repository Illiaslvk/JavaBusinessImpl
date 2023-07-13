package mp4.attribute;


import java.time.LocalDate;

public class Purchase {
    private LocalDate purchaseDate;
    private Customer customer;
    private Book book;
    public Purchase(LocalDate purchaseDate, Customer customer, Book book) {
        if (customer == null || book == null)
            throw new IllegalArgumentException("Book/Customer can not be null");
        setPurchaseDate(purchaseDate);
        setCustomer(customer);
        setBook(book);
    }

    ////////////////////Getters and Setters////////////////////

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }


    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    private void setCustomer(Customer customer) {
        if (this.customer == customer)
            return;

        this.customer = customer;

        if (this.customer != null)
            this.customer.addPurchases(this);
    }

    private void setBook(Book book) {
        if (this.book == book)
            return;

        this.book = book;

        if (this.book != null)
            this.book.addPurchases(this);
    }

    //Method
    public void remove() {
        if (book != null) {
            Book bk = this.book;
            setBook(null);
            bk.removePurchases(this);
        }
        if (customer != null) {
            Customer cr = this.customer;
            setCustomer(null);
            cr.removePurchases(this);
        }
    }

    @Override
    public String toString() {
        //made this to avoid recursion, without it, they will be printed endlessly
        String customerName = (this.customer != null) ? this.customer.getFirstName() : "";
        int bookID = (this.book != null) ? this.book.getIdBook() : -1;
        return "Purchase: bookID=" + bookID + ", customerName=" + customerName + ", purchaseDate=" + purchaseDate;
    }
}
