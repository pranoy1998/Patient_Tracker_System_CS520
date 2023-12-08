package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.repository.DoctorRepository;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    // Constructor-based Dependency Injection
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Method to retrieve all patients
    public Iterable<Doctor> getAllPatients() {
        return doctorRepository.findAll();
    }

    // Method to retrieve a specific patient by ID
    public Doctor getDoctorById(Integer doctorid) {
        return doctorRepository.findById(doctorid)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorid));
    }

}


