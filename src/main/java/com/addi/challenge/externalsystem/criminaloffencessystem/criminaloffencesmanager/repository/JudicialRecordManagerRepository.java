package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.JudicialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JudicialRecordManagerRepository extends JpaRepository<JudicialRecord, Long> {
    void deleteByJudicialRecordId(String judicialRecordId);
    List<JudicialRecord> findByNationalIdentificationNumber(String nationalIdentificationNumber);

}
