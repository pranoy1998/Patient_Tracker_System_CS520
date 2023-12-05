package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Service
public class PatientService {

    private final PatientRepository patientRepository;

    // Constructor-based Dependency Injection
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Method to retrieve all patients
    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Method to retrieve a specific patient by ID
    public Patient getPatientById(Integer patientid) {
        return patientRepository.findById(patientid)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientid));
    }

}
