package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    List<Appointment> findByDoctorDoctorid(Integer doctorid);
    List<Appointment> findByDoctor(Doctor doctor);
}
