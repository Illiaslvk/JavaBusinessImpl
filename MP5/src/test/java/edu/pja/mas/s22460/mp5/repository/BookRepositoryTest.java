package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.LearningBook;
import edu.pja.mas.s22460.mp5.model.LibrarySource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;

import static edu.pja.mas.s22460.mp5.model.SubjectType.IPB;
import static edu.pja.mas.s22460.mp5.model.SubjectType.MAS;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibrarySourceRepository librarySourceRepository;
    @Autowired
    private LearningBookRepository learningBookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    LearningBook lb1,lb2;
    LibrarySource ls1;

    @BeforeEach
    public void initData(){
        lb1 = LearningBook.builder()
                .subjectType(MAS)
                .pages(500)
                .additionalFeatures(new HashSet<>(Arrays.asList("Practice tasks","additional info")))
                .build();

        lb2 = LearningBook.builder()
                .subjectType(IPB)
                .pages(150)
                .additionalFeatures(new HashSet<>(Arrays.asList("Tasks to do")))
                .build();


        ls1 = LibrarySource.builder()
                .editionNumber(123456)
                .build();

    }

    @Test
    public void testRequiredDependencies(){
        assertNotNull(bookRepository);
        assertNotNull(librarySourceRepository);
        assertNotNull(learningBookRepository);
    }

    @Test
    public void testSaveAll() {
        learningBookRepository.saveAll(Arrays.asList(lb1, lb2));
        librarySourceRepository.save(ls1);
        entityManager.flush();
        //4 cuz i already added 1 book
        assertEquals(4, bookRepository.count());

    }

}