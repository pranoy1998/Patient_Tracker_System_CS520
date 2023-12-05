package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    List<Appointment> findByDoctorid(Integer doctorid);
}
