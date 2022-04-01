package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.CriminalOffence;

import java.util.List;

public interface CriminalOffencesManagerService {
    List<CriminalOffence> findAll();

    CriminalOffence findById(Long criminalOffenceId);

    CriminalOffence save(CriminalOffence criminalOffence);

    void deleteById(Long offenceId);
}
