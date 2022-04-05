package com.addi.challenge.externalsystem.judicialrecordssystem.judicialrecordsmanager.service;

import com.addi.challenge.externalsystem.judicialrecordssystem.judicialrecordsmanager.entity.JudicialRecord;

import java.util.List;

public interface JudicialRecordsManagerService {
    List<JudicialRecord> findAll();

    JudicialRecord save(JudicialRecord judicialRecord);

    void deleteByNationalIdentificationNumber(String nationalIdentificationNumber);

    JudicialRecord findByNationalIdentificationNumber(String nationalIdentificationNumber);

}


