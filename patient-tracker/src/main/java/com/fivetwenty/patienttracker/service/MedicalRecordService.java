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
}