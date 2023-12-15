package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    List<Appointment> findByDoctorDoctorid(Integer doctorid);
    List<Appointment> findByPatientid(Integer patientid);
    List<Appointment> getApptByDoctorId(Integer doctorid);
    List<Appointment> getApptTodayByDoctorId(Integer doctorid);
    List<Appointment> getApptByPatientId(Integer patientid);
    List<Appointment> getApptTodayByPatientId(Integer patientid);

}

