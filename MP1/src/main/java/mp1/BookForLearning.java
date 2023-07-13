package mp1;

import mp1.Validation.BookValidation;
import mp1.Validation.NullValidation;

import java.io.Serializable;

public class BookForLearning implements Serializable {
    private String subjectCategory;
    private int numOfPages;
    private String levelOfBook;

    public BookForLearning(String subjectCategory,int numOfPages) {
        setSubjectCategory(subjectCategory);
        setNumOfPages(numOfPages);
    }

    public BookForLearning(String subjectCategory, int numOfPages, String levelOfBook) {
        setSubjectCategory(subjectCategory);
        setNumOfPages(numOfPages);
        setLevelOfBook(levelOfBook);
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

    @Override
    public String toString() {
        return "BookForLearning{" +
                "subjectCategory='" + subjectCategory + '\'' +
                ", numOfPages=" + numOfPages +
                ", levelOfBook='" + levelOfBook + '\'' +
                '}';
    }

    public static void main(String[] args) {
        BookForLearning book1 = new BookForLearning("English", 200);
        System.out.println("Default: \n" + book1);
        book1.setLevelOfBook("Advanced");

        System.out.println("\nBook details:");
        System.out.println("Subject category: " + book1.getSubjectCategory());
        System.out.println("Number of pages: " + book1.getNumOfPages());
        System.out.println("Level of book: " + book1.getLevelOfBook());
    }

}
