package com.addi.challenge.externalsystem.judicialrecordssystem.judicialrecordsmanager.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class JudicialRecordsManagerControllerTest {

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