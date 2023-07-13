package mp3.abstractClass;

import mp3.BookGenre;
import mp3.NullValidation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibrarySource extends Book{

    private final List<Integer> releaseNumber = new ArrayList<>();
    private String releaseName;

    public LibrarySource(int idBook, String nameBook, String authorBook, BookGenre bookGenre,
                         Isbn isbnNumber, String releaseName){
        super(idBook,nameBook,authorBook, bookGenre, isbnNumber);
        setReleaseName(releaseName);
    }

    public LibrarySource(int idBook, String nameBook, String authorBook, BookGenre bookGenre,
                         Isbn isbnNumber, String releaseName,LocalDate datePurchase){
        super(idBook,nameBook,authorBook, bookGenre, isbnNumber, datePurchase);
        setReleaseName(releaseName);
    }

    // Release name
    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        if(releaseName == null || releaseName.isBlank()) {
            throw new NullValidation("Release name cannot be null");
        }
        this.releaseName = releaseName;
    }

    // Release number
    public List<Integer> getReleaseNumber() {
        return Collections.unmodifiableList(releaseNumber);
    }


    //business logic // redo it
    @Override
    public String obtain(String rel){
        if(rel == null || rel.isBlank()) {
            throw new NullValidation("Release number cannot be empty");
        }
        if(releaseNumber.contains(rel)){
            releaseNumber.remove(rel);
            return rel;
        }
        return null;
    }

}
