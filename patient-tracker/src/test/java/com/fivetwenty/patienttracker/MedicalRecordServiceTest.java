package test.java.com.fivetwenty.patienttracker;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class MedicalRecordServiceTest {

    @Mock
    private MedicalRecordRepository medicalRecordRepository;

    @InjectMocks
    private MedicalRecordService medicalRecordService;

    @Test
    void testGetMedicalRecordById() {
        Integer medicalRecordId = 1;
        MedicalRecord medicalRecord = new MedicalRecord(medicalRecordId, "Patient A's Medical Record");
        when(medicalRecordRepository.findById(medicalRecordId)).thenReturn(Optional.of(medicalRecord));
        MedicalRecord retrievedMedicalRecord = medicalRecordService.getMedicalRecordById(medicalRecordId);
        assertEquals(medicalRecord, retrievedMedicalRecord);
    }

    @Test
    void testGetMedicalRecordByIdMedicalRecordNotFound() {
        Integer medicalRecordId = 1;
        when(medicalRecordRepository.findById(medicalRecordId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> medicalRecordService.getMedicalRecordById(medicalRecordId));
    }
}
