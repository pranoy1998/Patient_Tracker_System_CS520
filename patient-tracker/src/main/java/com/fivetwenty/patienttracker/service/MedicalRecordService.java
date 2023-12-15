package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.model.MedicalRecord;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import com.fivetwenty.patienttracker.repository.MedicalRecordRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalrecordRepository;

    // Constructor-based Dependency Injection
    public MedicalRecordService(MedicalRecordRepository medicalrecordRepository) {
        this.medicalrecordRepository = medicalrecordRepository;
    }

    public MedicalRecord getMedicalRecordById(Integer medicalRecordId) {
        return medicalrecordRepository.findById(medicalRecordId)
                .orElseThrow(() -> new EntityNotFoundException("Medical Record not found with ID: " + medicalRecordId));
    }

    @Transactional
    public void uploadDocument(int patientId, byte[] documentData) {
        // Retrieve or create the medical record for the patient
        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientId(patientId)
                .orElseGet(() -> {
                    Patient patient = new Patient(); 
                    return new MedicalRecord(patient, null, null, documentData, null, null, null, null);
                });

        // Update the uploadeddocs field with the new document data
        medicalRecord.setUploadeddocs(documentData);

        // Save the medical record
        medicalRecordRepository.save(medicalRecord);
    }
}