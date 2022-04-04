package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.JudicialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JudicialRecordManagerRepository extends JpaRepository<JudicialRecord, Long> {
    JudicialRecord findByJudicialRecordId(String criminalOffenceId);
    void deleteByJudicialRecordId(String judicialRecordId);
    List<JudicialRecord> findByNationalIdentificationNumber(String nationalIdentificationNumber);

}
