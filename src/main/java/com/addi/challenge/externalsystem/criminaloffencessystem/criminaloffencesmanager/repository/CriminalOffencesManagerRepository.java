package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.CriminalOffence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriminalOffencesManagerRepository extends JpaRepository<CriminalOffence, Long> {
}
