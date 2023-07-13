package edu.pja.mas.s22460.mp5.repository;

import edu.pja.mas.s22460.mp5.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
