package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.controller;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.JudicialRecord;
import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service.JudicialRecordsManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/judicialrecords")
public class JudicialRecordsManagerController {

    private final JudicialRecordsManagerService judicialRecordsManagerService;

    public JudicialRecordsManagerController(JudicialRecordsManagerService judicialRecordsManagerService) {
        this.judicialRecordsManagerService = judicialRecordsManagerService;
    }

    @GetMapping
    public ResponseEntity<List<JudicialRecord>> findAll() {
        return new ResponseEntity<>(judicialRecordsManagerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JudicialRecord> save(@RequestBody JudicialRecord judicialRecord) {
        JudicialRecord savedCriminalOffence = judicialRecordsManagerService.save(judicialRecord);

        return new ResponseEntity<>(savedCriminalOffence, HttpStatus.CREATED);
    }

    @GetMapping("/{nationalIdentificationNumber}")
    @ResponseBody
    public ResponseEntity<List<JudicialRecord>> findByNationalIdentificationNumber(@PathVariable("nationalIdentificationNumber") String nationalIdentificationNumber) {
        List<JudicialRecord> judicialRecords = judicialRecordsManagerService.findByNationalIdentificationNumber(nationalIdentificationNumber);
        return new ResponseEntity<>(judicialRecords, HttpStatus.OK);
    }

    @DeleteMapping("/{judicialRecordId}")
    void deleteById(@PathVariable String judicialRecordId) {
        judicialRecordsManagerService.deleteByJudicialRecordId(judicialRecordId);
    }
}
