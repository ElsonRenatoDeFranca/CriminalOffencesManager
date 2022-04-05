package com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.service;

import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.entity.JudicialRecord;
import com.addi.challenge.externalsystem.criminaloffencessystem.criminaloffencesmanager.repository.JudicialRecordManagerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JudicialRecordsManagerServiceImplTest {

    @Mock
    private JudicialRecordManagerRepository repository;

    @InjectMocks
    private JudicialRecordsManagerServiceImpl judicialRecordsManagerService;

    @Test
    public void shouldReturnANotEmptyListWhenFindAllIsCalledAndThereIsAtLeastOneItemInTheDatabase() {
        when(repository.findAll()).thenReturn(createNotEmptyJudicialRecordMockList());
        List<JudicialRecord> actualOffense = this.judicialRecordsManagerService.findAll();

        assertThat(actualOffense).isNotNull();
        assertThat(actualOffense.isEmpty()).isFalse();
    }

    @Test
    public void shouldReturnAnEmptyListWhenFindAllIsCalledAndThereIsNoItemInDatabase() {
        when(repository.findAll()).thenReturn(createEmptyJudicialRecordMockList());
        List<JudicialRecord> actualJudicialRecord = this.judicialRecordsManagerService.findAll();

        assertThat(actualJudicialRecord).isNotNull();
        assertThat(actualJudicialRecord.isEmpty()).isTrue();
    }

    @Test
    public void shouldReturnNotNullWhenFindByIdIsCalled() {
        JudicialRecord expectedJudicialRecord = createJudicialRecordMock();

        when(repository.findByNationalIdentificationNumber(any())).thenReturn(expectedJudicialRecord);

        JudicialRecord actualJudicialRecord = this.judicialRecordsManagerService.findByNationalIdentificationNumber(expectedJudicialRecord.getNationalIdentificationNumber());

        assertThat(actualJudicialRecord).isNotNull();
        assertThat(actualJudicialRecord).isEqualTo(expectedJudicialRecord);
    }

    @Test
    public void shouldDeleteAnExistingOffenseFromTheDatabaseWhenDeleteByIdIsCalled() {
        JudicialRecord expectedJudicialRecord = createJudicialRecordMock();

        doNothing().when(repository).deleteByNationalIdentificationNumber(any());

        this.judicialRecordsManagerService.deleteByNationalIdentificationNumber(expectedJudicialRecord.getNationalIdentificationNumber());

        verify(repository, atLeast(1)).deleteByNationalIdentificationNumber(any());
    }


    @Test
    public void shouldAddANewOffenseToTheDatabaseWhenSaveIsCalled() {
        JudicialRecord expectedJudicialRecord = createJudicialRecordMock();

        when(repository.save(any())).thenReturn(expectedJudicialRecord);

        JudicialRecord actualJudicialRecord = this.judicialRecordsManagerService.save(expectedJudicialRecord);

        assertThat(actualJudicialRecord).isNotNull();
        assertThat(actualJudicialRecord).isEqualTo(expectedJudicialRecord);
        verify(repository, atLeast(1)).save(any());
    }

    private List<JudicialRecord> createNotEmptyJudicialRecordMockList() {
        return Arrays.asList(createJudicialRecordMock(), createJudicialRecordMock());
    }

    private List<JudicialRecord> createEmptyJudicialRecordMockList() {
        return Collections.emptyList();
    }

    private JudicialRecord createJudicialRecordMock() {
        return JudicialRecord.builder().nationalIdentificationNumber("90001")
                .build();
    }

}