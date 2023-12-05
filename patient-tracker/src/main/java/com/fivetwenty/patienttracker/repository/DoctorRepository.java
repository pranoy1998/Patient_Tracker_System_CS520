package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {}