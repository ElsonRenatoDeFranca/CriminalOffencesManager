package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.CriminalOffence;
import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.exception.CriminalOffenceNotFoundException;
import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository.CriminalOffencesManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalOffencesManagerServiceImpl implements CriminalOffencesManagerService {

    private final CriminalOffencesManagerRepository repository;

    private static final String CRIMINAL_OFFENCE_NOT_FOUND_MESSAGE = "Criminal offence not found";

    public CriminalOffencesManagerServiceImpl(CriminalOffencesManagerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CriminalOffence> findAll() {
        return repository.findAll();
    }

    @Override
    public CriminalOffence findById(Long criminalOffenceId) {
        try {
            return repository.findById(criminalOffenceId).orElseThrow(() -> new CriminalOffenceNotFoundException(CRIMINAL_OFFENCE_NOT_FOUND_MESSAGE));
        } catch (CriminalOffenceNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CriminalOffence save(CriminalOffence criminalOffence) {
        return repository.save(criminalOffence);
    }

    @Override
    public void deleteById(Long criminalOffenceId) {
        repository.deleteById(criminalOffenceId);
    }
}
