package mp3.abstractClass;

import mp3.BookGenre;
import mp3.BookValidation;
import mp3.NullValidation;

import java.time.LocalDate;


public class BookForLearning extends Book{

    private String subjectCategory;
    private int numOfPages;
    private String levelOfBook;

    public BookForLearning(int idBook, String nameBook, String authorBook, BookGenre bookGenre,
                           Isbn isbnNumber,String subjectCategory, int numOfPages, String levelOfBook) {
        super(idBook,nameBook,authorBook,bookGenre,isbnNumber);
        setSubjectCategory(subjectCategory);
        setNumOfPages(numOfPages);
        setLevelOfBook(levelOfBook);
    }

    public BookForLearning(int idBook, String nameBook, String authorBook, BookGenre bookGenre,
                           Isbn isbnNumber, String subjectCategory, int numOfPages, String levelOfBook,
                           LocalDate datePurchase) {
        super(idBook,nameBook,authorBook,bookGenre,isbnNumber,datePurchase);
        setSubjectCategory(subjectCategory);
        setNumOfPages(numOfPages);
        setLevelOfBook(levelOfBook);
    }

    ////////////////////Getters and Setters////////////////////

    //Subject

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        if (subjectCategory == null || subjectCategory.isBlank()) {
            throw new NullValidation("Category can not be empty");
        }
        this.subjectCategory = subjectCategory;
    }

    //Number of pages

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        if (numOfPages <= 0) {
            throw new BookValidation("Number of pages can not be negative");
        }
        this.numOfPages = numOfPages;
    }

    //Level of book

    public String getLevelOfBook() {
        return levelOfBook;
    }

    public void setLevelOfBook(String levelOfBook) {
        if (levelOfBook == null || levelOfBook.isBlank()) {
            throw new NullValidation("Level of book can not be empty");
        }
        this.levelOfBook = levelOfBook;
    }

    //METHOD
    @Override
    public String obtain(String res) {
        if(res == null || res.isBlank()) {
            throw new NullValidation("BookForLearning cannot be empty");
        }
        if(subjectCategory.contains(res)){
            return res;
        }
        return null;
    }

    //To string
    @Override
    public String toString() {
        return "BookForLearning{" +
                "subjectCategory=" + subjectCategory + '\n' +
                ", numOfPages=" + numOfPages + '\n' +
                ", levelOfBook=" + levelOfBook + '\n' +
                '}';
    }

}
