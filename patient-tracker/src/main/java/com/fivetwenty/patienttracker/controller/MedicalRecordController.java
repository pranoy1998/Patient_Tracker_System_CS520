package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.MedicalRecord;
import com.fivetwenty.patienttracker.repository.MedicalRecordRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {

    private final MedicalRecordRepository medicalRecordRepository;
    public MedicalRecordController(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }
    
    @GetMapping("/patient/{patientId}/uploaded-documents")
    public ResponseEntity<List<MedicalRecord>> getUploadedDocumentsByPatientId(@PathVariable int patientId) {
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordById(patientId);

        List<byte[]> uploadedDocuments = medicalRecords.stream()
                .map(MedicalRecord::getUploadeddocs)
                .collect(Collectors.toList());

        return ResponseEntity.ok(uploadedDocuments);
    }
}

