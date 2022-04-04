package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CriminalOffencesManagerControllerTest {

    /*@Mock
    private CriminalOffencesManagerService criminalOffencesManagerService;

    @InjectMocks
    private CriminalOffencesManagerController criminalOffencesManagerController;

    @Test
    public void shouldReturnANotEmptyListWhenFindAllIsCalledAndThereIsAtLeastOneItemInTheDatabase() {
        when(criminalOffencesManagerService.findAll()).thenReturn(createNotEmptyCriminalOffenceMockList());

        ResponseEntity<List<CriminalOffence>> actualCriminalOffence = this.criminalOffencesManagerController.findAll();

        assertThat(actualCriminalOffence).isNotNull();
        assertThat(actualCriminalOffence.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase() {
        when(criminalOffencesManagerService.findAll()).thenReturn(createEmptyCriminalOffenceMockList());

        ResponseEntity<List<CriminalOffence>> actualCriminalOffence = this.criminalOffencesManagerController.findAll();

        assertThat(actualCriminalOffence).isNotNull();
        assertThat(actualCriminalOffence.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled() {
        CriminalOffence expectedPerson = createCriminalOffenceMock();

        when(criminalOffencesManagerService.findByCriminalOffenceId(any())).thenReturn(expectedPerson);

        ResponseEntity<CriminalOffence> actualPerson = this.criminalOffencesManagerController.findByCriminalOffenceId(expectedPerson.getCriminalOffenceId());

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualPerson.getBody()).isEqualTo(expectedPerson);
    }

    @Test
    public void shouldDeleteAnExistingCriminalOffenceFromTheDatabaseWhenDeleteByIdIsCalled() {
        CriminalOffence expectedPerson = createCriminalOffenceMock();

        doNothing().when(criminalOffencesManagerService).deleteById(any());

        this.criminalOffencesManagerController.deleteById(expectedPerson.getId());

        verify(criminalOffencesManagerService, atLeast(1)).deleteById(any());
    }

    @Test
    public void shouldAddANewCriminalOffenceToTheDatabaseWhenSaveMethodIsCalled() {
        CriminalOffence expectedPerson = createCriminalOffenceMock();

        when(criminalOffencesManagerService.save(any())).thenReturn(expectedPerson);

        ResponseEntity<CriminalOffence> actualPerson = this.criminalOffencesManagerController.save(expectedPerson);

        assertThat(actualPerson).isNotNull();
        assertThat(actualPerson.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(criminalOffencesManagerService, atLeast(1)).save(any());
    }


    private List<CriminalOffence> createNotEmptyCriminalOffenceMockList() {
        return Arrays.asList(createCriminalOffenceMock(), createCriminalOffenceMock());
    }

    private List<CriminalOffence> createEmptyCriminalOffenceMockList() {
        return Collections.emptyList();
    }

    private CriminalOffence createCriminalOffenceMock() {
        return CriminalOffence.builder()
                .id(1L)
                .description("Home invasion")
                .maximumFine("100")
                .probationTerm("10")
                .maximumPrisonTerm("10")
                .build();
    }

     */
}