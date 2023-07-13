package mp4.busConstraint;


import mp4.NullValidation;

//With an attribute
public class LimitReservation {
    private int howManyTimeBookReserved;
    private int maxBookReserved;
    private Reservation reservation;
    private Book book;

    public LimitReservation(int howManyTimeBookReserved, int maxBookReserved, Reservation reservation, Book book) {
        setHowManyTimeBookReserved(howManyTimeBookReserved);
        setMaxBookReserved(maxBookReserved);
        setReservation(reservation);
        setBook(book);
    }

    // How many times book reserved

    public int getHowManyTimeBookReserved() {
        return howManyTimeBookReserved;
    }

    public void setHowManyTimeBookReserved(int howManyTimeBookReserved) {
        this.howManyTimeBookReserved = howManyTimeBookReserved;
    }

    // Max Book reserved - that how many times book can be reserved by client

    public int getMaxBookReserved() {
        return maxBookReserved;
    }

    public void setMaxBookReserved(int maxBookReserved) {
        this.maxBookReserved = maxBookReserved;
    }

    // Reservation

    public Reservation getReservation() {
        return reservation;
    }

    private void setReservation(Reservation reservation) {
        if(reservation == null) {
            throw new NullValidation("Reservation cannot be null");
        }
        this.reservation = reservation;
        reservation.addLimitReservation(this);
    }

    //Book

    public Book getBook() {
        return book;
    }

    private void setBook(Book book) {
        if(book == null) {
            throw new NullValidation("Book cannot be null!!!");
        }
        if(book.getLimitReservation() != null) {
            book.getLimitReservation().remove();
        }
        this.book = book;
        book.setLimitReservation(this);
    }

    //Method
    public void remove(){
        if(this.book != null) {
            Book bk = this.book;
            this.book = null;
            bk.setLimitReservation(null);
        }
        if(this.reservation != null) {
            Reservation reserv = this.reservation;
            this.reservation = null;
            reserv.removeLimitReservation(this);
        }
    }
}
