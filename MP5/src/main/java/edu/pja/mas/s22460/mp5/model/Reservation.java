package edu.pja.mas.s22460.mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "book_id",
//                "customer_id"
//        })
//})
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JoinColumn(name = "book_id", nullable = false)
    @NotNull
    private Set<Book> books;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull
    private Customer customer;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

}
