package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.JudicialRecord;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JudicialRecordsManagerService {
    JudicialRecord findByJudicialRecordId(String judicialRecordId);

    List<JudicialRecord> findAll();

    JudicialRecord save(JudicialRecord judicialRecord);

    void deleteByJudicialRecordId(String judicialRecordId);

    List<JudicialRecord> findByNationalIdentificationNumber(String nationalIdentificationNumber);

}


