package edu.pja.mas.s22460.mp5.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="book_name")
    private String bookName;

    @Column(name="author_name")
    private String authorName;

    //Basic
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "library_id")
    private Library library;

    //With Attribute
    @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation> reservations;

    //Composition
    //CascadeType.ALL ensures that the Opinion entity is
    //created, updated, and deleted along with the Book entity
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @ToString.Exclude // Excludes this field from the toString() method
    @EqualsAndHashCode.Exclude
    private Set<Opinion> opinions = new HashSet<>();


}