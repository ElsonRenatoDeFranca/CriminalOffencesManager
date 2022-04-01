package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@EqualsAndHashCode(exclude = {"name"})
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CriminalOffence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String maximumPrisonTerm;
    private String maximumFine;
    private String probationTerm;;
}