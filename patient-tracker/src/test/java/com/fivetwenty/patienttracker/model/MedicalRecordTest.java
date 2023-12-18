package com.fivetwenty.patienttracker.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.model.MedicalRecord;
import com.fivetwenty.patienttracker.model.Patient;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicalRecordTest {

    @Test
    public void testMedicalRecordGettersAndSetters() {
        // Create a sample LocalDateTime instance for testing
        LocalDateTime sampleDateTime = LocalDateTime.now();

        // Create a sample Patient instance for testing
        Patient samplePatient = new Patient();
        samplePatient.setPatientid(123);

        // Create a MedicalRecord instance
        MedicalRecord medicalRecord = new MedicalRecord();

        // Set values using setters
        medicalRecord.setRecordId(1);
        medicalRecord.setPatientNotes("Patient notes");
        medicalRecord.setDoctorNotes("Doctor notes");
        medicalRecord.setMedicalHistory("Medical history");
        medicalRecord.setUpdatedBy(456);
        medicalRecord.setCurrentMedication("Current medication");
        medicalRecord.setPreviousDiagnosis("Previous diagnosis");
        medicalRecord.setPatient(samplePatient);
        medicalRecord.setSubmissionDate(sampleDateTime);

        // Verify values using getters
        assertEquals(1, medicalRecord.getRecordId());
        assertEquals("Patient notes", medicalRecord.getPatientNotes());
        assertEquals("Doctor notes", medicalRecord.getDoctorNotes());
        assertEquals("Medical history", medicalRecord.getMedicalHistory());
        assertEquals(456, medicalRecord.getUpdatedBy());
        assertEquals("Current medication", medicalRecord.getCurrentMedication());
        assertEquals("Previous diagnosis", medicalRecord.getPreviousDiagnosis());
        assertEquals(samplePatient, medicalRecord.getPatient());
        assertEquals(sampleDateTime, medicalRecord.getSubmissionDate());
    }
}
