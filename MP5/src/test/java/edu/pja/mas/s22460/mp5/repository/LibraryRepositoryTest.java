package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.Library;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LibraryRepositoryTest {

    //video - 1
    @Autowired
    private LibraryRepository libraryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Library l1;

    @BeforeEach
    public void  initData(){
        l1 = Library.builder()
                .libraryName("SSS")
                .build();
    }

    @Test
    public void testRequiredDependencies(){
        assertNotNull(libraryRepository);
    }

    @Test
    public void testFetchBooks(){
        Iterable<Library> all = libraryRepository.findAll();
        for (Library l : all){
            System.out.println(l);
        }
    }

    @Test
    public void testSaveLibrary(){
        libraryRepository.save(l1);
        entityManager.flush(); // this allows to save it immediately
        long count = libraryRepository.count();
        assertEquals(2,count);
    }

    @Test
    public void testSaveInvalidBookName(){
        assertThrows(ConstraintViolationException.class, () -> {
            l1.setLibraryName("s");
            libraryRepository.save(l1);
            entityManager.flush();
        });;
    }

    @Test
    public void testFindLibraryByName(){
        List<Library> libraryList = libraryRepository.findByLibraryName("SSS");
        System.out.println(libraryList);
        assertEquals(1,libraryList.size());
    }


}
