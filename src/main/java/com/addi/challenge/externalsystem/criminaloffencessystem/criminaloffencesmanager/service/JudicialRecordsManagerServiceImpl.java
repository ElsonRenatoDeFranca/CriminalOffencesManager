package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.JudicialRecord;
import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository.JudicialRecordManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudicialRecordsManagerServiceImpl implements JudicialRecordsManagerService {

    private final JudicialRecordManagerRepository judicialRecordManagerRepository;

    public JudicialRecordsManagerServiceImpl(JudicialRecordManagerRepository judicialRecordManagerRepository) {
        this.judicialRecordManagerRepository = judicialRecordManagerRepository;
    }

    @Override
    public List<JudicialRecord> findAll() {
        return judicialRecordManagerRepository.findAll();
    }

    @Override
    public JudicialRecord save(JudicialRecord judicialRecord) {
        return judicialRecordManagerRepository.save(judicialRecord);
    }

    @Override
    public void deleteByNationalIdentificationNumber(String nationalIdentificationNumber) {
        judicialRecordManagerRepository.deleteByNationalIdentificationNumber(nationalIdentificationNumber);
    }

    @Override
    public JudicialRecord findByNationalIdentificationNumber(String nationalIdentificationNumber) {
        return judicialRecordManagerRepository.findByNationalIdentificationNumber(nationalIdentificationNumber);
    }
}
