package com.fivetwenty.patienttracker.service;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.model.MedicalRecord;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.MedicalRecordRepository;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import com.fivetwenty.patienttracker.response.PatientDetailsResponse;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordServiceTest {

    @Test
    public void testGetPatientDetails() {
        // Mock MedicalRecordRepository and PatientRepository
        MedicalRecordRepository medicalRecordRepository = mock(MedicalRecordRepository.class);
        PatientRepository patientRepository = mock(PatientRepository.class);

        // Create an instance of MedicalRecordService with the mocked repositories
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepository, patientRepository);

        // Mock data for MedicalRecord
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedicalHistory("History");
        medicalRecord.setCurrentMedication("Medication");
        medicalRecord.setPreviousDiagnosis("Diagnosis");
        medicalRecord.setDoctorNotes("Doctor's Notes");
        medicalRecord.setPatientNotes("Patient's Notes");

        // Mock patient's details
        when(patientRepository.findByPatientid(1)).thenReturn(new Patient(1, LocalDate.ofYearDay(2021, 4), "name", "contactinformation", "email")); // Mock patient existence
        when(medicalRecordRepository.findById(1)).thenReturn(java.util.Optional.of(medicalRecord));

        // Test when a valid MedicalRecord is found for the given patient ID
        PatientDetailsResponse patientDetails = medicalRecordService.getPatientDetails(1);
        assertNotNull(patientDetails);
        assertEquals("History", patientDetails.getMedicalHistory());
        assertEquals("Medication", patientDetails.getCurrentMedications());
        assertEquals("Diagnosis", patientDetails.getPreviousDiagnosis());
        assertEquals("Doctor's Notes", patientDetails.getDoctorNotes());
        assertEquals("Patient's Notes", patientDetails.getPatientNotes());

    }


}
