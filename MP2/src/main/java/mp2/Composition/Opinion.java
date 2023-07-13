package mp2.Composition;

//Composition

import mp2.Book;
import mp2.Validation.BookValidation;
import mp2.Validation.NullValidation;

public class Opinion {
    private int rating;
    private String comment;

    private Book book;

    private Opinion(int rating, String comment, Book book){
        setRating(rating);
        setComment(comment);
        setBook(book);
    }

    public static Opinion createOpinion(int rating,String comment,Book book){
        Opinion opinion = new Opinion(rating,comment,book);
        book.addOpinion(opinion);
        return opinion;
    }

    // rating

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating < 1 | rating > 5) {
            throw new BookValidation("Rating can be only between 1 and 5");
        }
        this.rating = rating;
    }

    // Comment
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(comment.length() > 500){
            throw new BookValidation("Comment cannot be longer than 500 characters");
        }
        this.comment = comment;
    }

    // Book
    public Book getBook() {
        return book;
    }

    private void setBook(Book book) {
        if(book == null) {
            throw new NullValidation("Book cannot be null");
        }
        this.book = book;
    }

    //Method
    public void delete(){
        if(this.book == null) {
            return;
        }
        Book book1 = this.book;
        this.book = null;
        book1.removeOpinion(this);
    }


    //To string
    @Override
    public String toString() {
        return "Opinion{" + '\n' +
                "rating = " + rating + '\n' +
                "comment = " + comment + '\n' +
                "book = " + book.getNameBook() + '\n' +
                '}';
    }
}
