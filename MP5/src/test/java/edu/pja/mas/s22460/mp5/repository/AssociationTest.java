package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.Book;
import edu.pja.mas.s22460.mp5.model.LearningBook;
import edu.pja.mas.s22460.mp5.model.Library;
import edu.pja.mas.s22460.mp5.model.LibrarySource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static edu.pja.mas.s22460.mp5.model.SubjectType.IPB;
import static edu.pja.mas.s22460.mp5.model.SubjectType.MAS;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AssociationTest {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibrarySourceRepository librarySourceRepository;
    @Autowired
    private LearningBookRepository learningBookRepository;

    Library l1;
    LearningBook lb1;
    LibrarySource ls1;

    @Test
    public void testRequiredDependencies(){
        assertNotNull(libraryRepository);
        assertNotNull(bookRepository);
        assertNotNull(librarySourceRepository);
        assertNotNull(learningBookRepository);
    }

    @BeforeEach
    public void initData() {
        l1 = Library.builder()
                .libraryName("Hogwarts")
                .build();

        lb1 = LearningBook.builder()
                .subjectType(IPB)
                .pages(150)
                .additionalFeatures(new HashSet<>(Arrays.asList("Tasks to do")))
                .build();

        ls1 = LibrarySource.builder()
                .editionNumber(123456)
                .build();
    }

    @Test
    public void testSave(){
        l1.getBooks().add(lb1);
        l1.getBooks().add(ls1);
        libraryRepository.save(l1);
        lb1.setLibrary(l1);
        ls1.setLibrary(l1);
        bookRepository.save(lb1);
        bookRepository.save(ls1);

        Optional<Library> byId = libraryRepository.findById(l1.getId());
        assertTrue(byId.isPresent());
        System.out.println(byId.get().getBooks());
        assertEquals(2, byId.get().getBooks().size());
    }
}


