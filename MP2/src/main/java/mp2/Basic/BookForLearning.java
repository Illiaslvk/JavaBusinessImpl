package mp2.Basic;

//Basic

import mp2.Book;
import mp2.Validation.BookValidation;
import mp2.Validation.NullValidation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookForLearning implements Serializable {

        private String subjectCategory;
        private int numOfPages;
        private String levelOfBook;
        private Book book;
        private List<Book> relatedBooks;


        public BookForLearning(String subjectCategory, int numOfPages, String levelOfBook) {
            setSubjectCategory(subjectCategory);
            setNumOfPages(numOfPages);
            setLevelOfBook(levelOfBook);
            relatedBooks = new ArrayList<>();
        }

        public BookForLearning(String subjectCategory, int numOfPages, String levelOfBook, Book book) {
            setSubjectCategory(subjectCategory);
            setNumOfPages(numOfPages);
            setLevelOfBook(levelOfBook);
            setBook(book);

        }

        ////////////////////Getters and Setters////////////////////

        public String getSubjectCategory() {
            return subjectCategory;
        }

        public int getNumOfPages() {
            return numOfPages;
        }

        public String getLevelOfBook() {
            return levelOfBook;
        }

        public void setSubjectCategory(String subjectCategory) {
            if (subjectCategory == null || subjectCategory.isBlank()) {
                throw new NullValidation("Category can not be empty");
            }
            this.subjectCategory = subjectCategory;
        }

        public void setNumOfPages(int numOfPages) {
            if (numOfPages <= 0) {
                throw new BookValidation("Number of pages can not be negative");
            }
            this.numOfPages = numOfPages;
        }

        public void setLevelOfBook(String levelOfBook) {
            if (levelOfBook == null || levelOfBook.isBlank()) {
                throw new NullValidation("Level of book can not be empty");
            }
            this.levelOfBook = levelOfBook;
        }

        //Book

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            if(this.book == book) {
                return;
            }
            if(this.book != null) {
                this.book.setBookLevel(null);
            }
            this.book = book;
            if(this.book != null) {
                this.book.setBookLevel(this);
            }
        }

        public void addBookForLearning(Book book) {
            if (book != null) {
                book.setBookLevel(this);
                relatedBooks.add(book);
            }
        }

        public void removeBookForLearning(Book book){
            if(book == null){
                throw new IllegalArgumentException("Book doesn't exist");
            }
            if(!this.relatedBooks.contains(book)){
                return;
            }
            relatedBooks.remove(book);
        }

        public List<Book> getRelatedBooks() {
            return Collections.unmodifiableList(relatedBooks);
        }

        public void setRelatedBooks(List<Book> relatedBooks) {
            this.relatedBooks = relatedBooks;
        }


        //To string

        @Override
        public String toString() {
            return "BookForLearning{" +
                    "subjectCategory='" + subjectCategory + '\'' +
                    ", numOfPages=" + numOfPages +
                    ", levelOfBook='" + levelOfBook + '\'' +
                    '}';
        }


}