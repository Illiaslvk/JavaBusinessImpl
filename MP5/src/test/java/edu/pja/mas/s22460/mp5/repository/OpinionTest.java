package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.LearningBook;
import edu.pja.mas.s22460.mp5.model.LibrarySource;
import edu.pja.mas.s22460.mp5.model.Opinion;
import edu.pja.mas.s22460.mp5.model.SubjectType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class OpinionTest {

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testCreateOpinionWithLibrarySource() {
        // Create a new LibrarySource
        LibrarySource librarySource = LibrarySource.builder()
                .bookName("Sample Book")
                .authorName("John Doe")
                .editionNumber(1)
                .build();

        // Save the LibrarySource to the database
        bookRepository.save(librarySource);

        // Create a new opinion
        Opinion opinion = Opinion.builder()
                .book(librarySource)
                .rating("5 stars")
                .comment("Great book!")
                .build();

        // Save the opinion to the database
        opinionRepository.save(opinion);

        // Clear the persistence context to force a database flush and ensure data consistency
        entityManager.flush();
        entityManager.clear();

        // Retrieve the opinion from the database
        Opinion savedOpinion = opinionRepository.findById(opinion.getId()).orElse(null);
        assertNotNull(savedOpinion);
        assertNotNull(savedOpinion.getBook());
        assertEquals("Sample Book", savedOpinion.getBook().getBookName());
        assertEquals("John Doe", savedOpinion.getBook().getAuthorName());
    }

    @Test
    public void testCreateOpinionWithLearningBook() {
        // Create a new LearningBook
        LearningBook learningBook = LearningBook.builder()
                .bookName("Sample Learning Book")
                .authorName("Jane Smith")
                .subjectType(SubjectType.PRO)
                .pages(200)
                .additionalFeatures(new HashSet<>(Arrays.asList("smth", "smth")))
                .build();

        // Save the LearningBook to the database
        bookRepository.save(learningBook);

        // Create a new opinion
        Opinion opinion = Opinion.builder()
                .book(learningBook)
                .rating("4 stars")
                .comment("Informative content")
                .build();

        // Save the opinion to the database
        opinionRepository.save(opinion);

        // Clear the persistence context to force a database flush and ensure data consistency
        entityManager.flush();
        entityManager.clear();

        // Retrieve the opinion from the database
        Opinion savedOpinion = opinionRepository.findById(opinion.getId()).orElse(null);
        assertNotNull(savedOpinion);
        assertNotNull(savedOpinion.getBook());
        assertEquals("Sample Learning Book", savedOpinion.getBook().getBookName());
        assertEquals("Jane Smith", savedOpinion.getBook().getAuthorName());
    }

}
