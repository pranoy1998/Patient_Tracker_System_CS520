package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    // Constructor-based Dependency Injection
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Patient> getPatientsByDoctorId(Integer doctorid) {
        List<Appointment> appointments = appointmentRepository.findByDoctorDoctorid(doctorid);

        // Extract patients from appointments
        return appointments.stream()
                .map(Appointment::getPatientid)
                .collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsForDoctor(Doctor doctor) {
        return appointmentRepository.findByDoctor(doctor);
    }
}

