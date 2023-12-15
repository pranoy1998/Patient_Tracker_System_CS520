package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.MedicalRecord;
import com.fivetwenty.patienttracker.repository.MedicalRecordRepository;

import java.io.IOException;
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

    @PostMapping("/patient/{patientId}/upload-document")
    public ResponseEntity<String> uploadDocument(
            @PathVariable int patientId,
            @RequestParam("file") MultipartFile file) {
        try {
            // Assuming you have a service method to handle the file upload and associate it with the patient
            medicalRecordService.uploadDocument(patientId, file.getBytes());

            return ResponseEntity.status(HttpStatus.CREATED).body("Document uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload document.");
        }
    }
}

