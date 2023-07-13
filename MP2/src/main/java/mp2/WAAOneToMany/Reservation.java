package mp2.WAAOneToMany;

// With an attribute

import mp2.Book;
import mp2.Validation.BookValidation;
import mp2.Validation.NullValidation;
import mp2.WAAOneToMany.LimitReservation;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Reservation {
    private LocalDate startDate;
    private LocalDate endDate;
    private int stateBookBefore;
    private int stateBookAfter;

    private final Set<LimitReservation> limitReservations = new HashSet<>();
    private Book book;

    public Reservation(LocalDate startDate, LocalDate endDate, int stateBookBefore, int stateBookAfter){
        setStartDate(startDate);
        setEndDate(endDate);
        setStateBookBefore(stateBookBefore);
        setStateBookAfter(stateBookAfter);
    }

    // Book

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        if(book == null) {
            throw new NullValidation("Book cannot be null");
        }
        this.book = book;
    }

    // start date

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if(startDate == null) {
            throw new NullValidation("Start date cannot be null");
        } else if(startDate.isAfter(LocalDate.now())) {
            throw new BookValidation("Start date cannot be in future");
        }
        this.startDate = startDate;
    }

    //end date


    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if(endDate == null) {
            throw new NullValidation("End date cannot be null");
        } else if (endDate.isBefore(startDate)){
            throw new BookValidation("End date cannot be before start date");
        }
        this.endDate = endDate;
    }

    // state of the book before reservation

    public int getStateBookBefore() {
        return stateBookBefore;
    }

    public void setStateBookBefore(int stateBookBefore) {
        if((Integer)stateBookBefore == null) {
            throw new NullValidation("State of the book before reservation cannot be null!!!");
        } else if (stateBookBefore < 1 | stateBookBefore > 5) {
            throw new BookValidation("State of the book before reservation must be smaller than 5 and bigger than 1");
        }
        this.stateBookBefore = stateBookBefore;
    }

    // state of the book after reservation

    public int getStateBookAfter() {
        return stateBookAfter;
    }

    public void setStateBookAfter(int stateBookAfter) {
        if((Integer)stateBookAfter == null) {
            throw new NullValidation("State of the book after reservation cannot be null!!!");
        } else if(stateBookAfter < 1 | stateBookAfter > 5) {
            throw new BookValidation("State of the book after reservation must be smaller than 5 and bigger than 1");
        }
        this.stateBookAfter = stateBookAfter;
    }

    //Limit reservation
    public Set<LimitReservation> getLimitReservations() {
        return Collections.unmodifiableSet(limitReservations);
    }

    public void addLimitReservation(LimitReservation limitReservation) {
        if(limitReservation == null) {
            throw new NullValidation("Limit Reservation cannot be null!!");
        }
        if(limitReservation.getReservation() != this) {
            throw new BookValidation("This limit reservation is for not this person");
        }
        this.limitReservations.add(limitReservation);
    }

    public void removeLimitReservation(LimitReservation limitReservation) {
        if(limitReservation == null) {
            throw new NullValidation("Limit reservation cannot be null!");
        }
        this.limitReservations.remove(limitReservation);
        if(limitReservation.getReservation() == this) {
            limitReservation.remove();
        }
    }
}
