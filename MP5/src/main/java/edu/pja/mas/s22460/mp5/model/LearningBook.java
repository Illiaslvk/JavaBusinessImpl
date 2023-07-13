package edu.pja.mas.s22460.mp5.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LearningBook extends Book{

    @NotNull
    private SubjectType subjectType;
    private int pages;

    @ElementCollection
    @CollectionTable(name = "additional_features")
    @Column(name = "feature")
    private Set<String> additionalFeatures = new HashSet<>();

}
