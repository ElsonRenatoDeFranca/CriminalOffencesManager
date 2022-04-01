package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.CriminalOffence;
import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository.CriminalOffencesManagerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CriminalOffencesManagerServiceImplTest {

    @Mock
    private CriminalOffencesManagerRepository repository;

    @InjectMocks
    private CriminalOffencesManagerServiceImpl criminalOffencesManagerService;

    private static final String CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE = "Criminal offence not found";

    @Test
    public void shouldReturnANotEmptyListWhenFindAllIsCalledAndThereIsAtLeastOneItemInTheDatabase() {
        when(repository.findAll()).thenReturn(createNotEmptyCriminalOffenceMockList());
        List<CriminalOffence> actualOffense = this.criminalOffencesManagerService.findAll();

        assertThat(actualOffense).isNotNull();
        assertThat(actualOffense.isEmpty()).isFalse();
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase() {
        when(repository.findAll()).thenReturn(createEmptyCriminalOffenceMockList());
        List<CriminalOffence> actualOffence = this.criminalOffencesManagerService.findAll();

        assertThat(actualOffence).isNotNull();
        assertThat(actualOffence.isEmpty()).isTrue();
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled() {
        CriminalOffence expectedCriminalOffence = createCriminalOffenceMock();

        when(repository.findById(anyLong())).thenReturn(Optional.of(expectedCriminalOffence));

        CriminalOffence actualCriminalOffence = this.criminalOffencesManagerService.findById(expectedCriminalOffence.getId());

        assertThat(actualCriminalOffence).isNotNull();
        assertThat(actualCriminalOffence).isEqualTo(expectedCriminalOffence);
    }

    @Test
    public void shouldDeleteAnExistingOffenseFromTheDatabaseWhenDeleteByIdIsCalled() {
        CriminalOffence expectedCriminalOffence = createCriminalOffenceMock();

        doNothing().when(repository).deleteById(any());

        this.criminalOffencesManagerService.deleteById(expectedCriminalOffence.getId());

        verify(repository, atLeast(1)).deleteById(any());
    }


    @Test
    public void shouldAddANewOffenseToTheDatabaseWhenSaveIsCalled() {
        CriminalOffence expectedCriminalOffence = createCriminalOffenceMock();

        when(repository.save(any())).thenReturn(expectedCriminalOffence);

        CriminalOffence actualCriminalOffence = this.criminalOffencesManagerService.save(expectedCriminalOffence);

        assertThat(actualCriminalOffence).isNotNull();
        assertThat(actualCriminalOffence).isEqualTo(expectedCriminalOffence);
        verify(repository, atLeast(1)).save(any());
    }

    @Test
    public void shouldThrowAnOffenseNotFoundExceptionWhenFindByIdIsCalledWithUnknownId() {
        CriminalOffence expectedCriminalOffence = createCriminalOffenceMock();

        when(repository.findById(anyLong())).thenThrow(new RuntimeException(CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE));

        Throwable exception = assertThrows(RuntimeException.class,
                () -> this.criminalOffencesManagerService.findById(expectedCriminalOffence.getId()));

        assertThat(CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE).isEqualTo(exception.getMessage());
    }

    @Test
    public void shouldThrowAnOffenseNotFoundExceptionWhenDeleteByIdIsCalledWithUnknownId() {
        CriminalOffence expectedCriminalOffence = createCriminalOffenceMock();

        doThrow(new RuntimeException(CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE)).when(repository).deleteById(anyLong());

        Throwable exception = assertThrows(RuntimeException.class,
                () -> this.criminalOffencesManagerService.deleteById(expectedCriminalOffence.getId()));

        assertThat(CRIMINAL_OFFENCE_NOT_FOUND_EXCEPTION_MESSAGE).isEqualTo(exception.getMessage());
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
                .description("Assassination")
                .maximumPrisonTerm("10")
                .maximumFine("10")
                .probationTerm("5")
                .build();
    }

}