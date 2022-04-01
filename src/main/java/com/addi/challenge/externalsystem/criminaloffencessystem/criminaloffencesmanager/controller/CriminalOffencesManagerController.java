package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.controller;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.CriminalOffence;
import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service.CriminalOffencesManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criminalOffences")
public class CriminalOffencesManagerController {

    private final CriminalOffencesManagerService criminalOffencesManagerService;

    public CriminalOffencesManagerController(CriminalOffencesManagerService criminalOffencesManagerService) {
        this.criminalOffencesManagerService = criminalOffencesManagerService;
    }

    @GetMapping
    public ResponseEntity<List<CriminalOffence>> findAll() {
        return new ResponseEntity<>(criminalOffencesManagerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CriminalOffence> save(@RequestBody CriminalOffence offense) {
        CriminalOffence savedCriminalOffence = criminalOffencesManagerService.save(offense);

        return new ResponseEntity<>(savedCriminalOffence, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CriminalOffence> findById(@PathVariable("id") Long id) {
        CriminalOffence criminalOffence = criminalOffencesManagerService.findById(id);
        return new ResponseEntity<>(criminalOffence, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        criminalOffencesManagerService.deleteById(id);
    }
}
