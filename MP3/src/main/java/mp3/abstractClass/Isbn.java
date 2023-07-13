package mp3.abstractClass;

import java.io.Serializable;

public class Isbn implements Serializable {
    private String isbn;
    private int uniqueNumber;

    public Isbn (String isbn, int uniqueNumber) {
        this.isbn = isbn;
        this.uniqueNumber = uniqueNumber;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    @Override
    public String toString() {
        return isbn + " " + uniqueNumber;
    }
}
