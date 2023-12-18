package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    Patient findByPatientid(int patientid);
}
