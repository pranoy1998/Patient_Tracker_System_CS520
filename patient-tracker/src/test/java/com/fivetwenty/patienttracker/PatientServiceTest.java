package test.java.com.fivetwenty.patienttracker;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    void testGetAllPatients() {
        List<Patient> patients = Arrays.asList(
                new Patient(1, "Patient A"),
                new Patient(2, "Patient B")
        );
        when(patientRepository.findAll()).thenReturn(patients);
        Iterable<Patient> allPatients = patientService.getAllPatients();
        assertEquals(patients, allPatients);
    }

    @Test
    void testGetPatientById() {
        Integer patientId = 1;
        Patient patient = new Patient(patientId, "Patient A");
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
        Patient retrievedPatient = patientService.getPatientById(patientId);
        assertEquals(patient, retrievedPatient);
    }

    @Test
    void testGetPatientByIdPatientNotFound() {
        Integer patientId = 1;
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> patientService.getPatientById(patientId));
    }
}
