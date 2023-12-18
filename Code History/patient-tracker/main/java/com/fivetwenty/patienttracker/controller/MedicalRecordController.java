package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.repository.MedicalRecordRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MedicalRecordController {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordController(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }
}

