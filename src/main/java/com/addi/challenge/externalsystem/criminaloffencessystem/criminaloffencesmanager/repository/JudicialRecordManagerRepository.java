package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.JudicialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JudicialRecordManagerRepository extends JpaRepository<JudicialRecord, Long> {
    void deleteByNationalIdentificationNumber(String judicialRecordId);
    JudicialRecord findByNationalIdentificationNumber(String nationalIdentificationNumber);

}
