package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.Library;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends CrudRepository<Library,Long> {
        public List<Library> findByLibraryName(String name);

        @Query("from Library as l left join fetch l.books where l.id = :id")
        public Optional<Library> findById (@Param("id") Long id);

}
