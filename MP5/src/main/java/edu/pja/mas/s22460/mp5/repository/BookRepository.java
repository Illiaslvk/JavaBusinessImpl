package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

}
