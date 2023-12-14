package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<Doctor> getDoctorByPatientId(Integer patientid) {
        List<Appointment> appointments = appointmentRepository.findByPatientid(patientid);

        // Extract doctors from appointments
        return appointments.stream()
                .map(Appointment::getDoctorid)
                .collect(Collectors.toList());
    }

    public List<Appointment> getApptByDoctorId(Integer doctorId) {
        List<Appointment> appointments = appointmentRepository.getApptByDoctorId(doctorId);
        
        
        Map<String, List<AppointmentDetails>> appointmentMap = new HashMap<>();

        for (Appointment appointment : appointments) {
            LocalDateTime dateTime = appointment.getAppointmentDateTime();
            String key = dateTime.getDayOfWeek() + " : " + dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            appointmentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new AppointmentDetails(
                    dateTime.format(DateTimeFormatter.ofPattern("h:mm a")),
                    appointment.getPatientid().getName(),
                    appointment.getPatientid().getPatientid()
            ));
        }
        
        
        return appointmentMap.entrySet()
                .stream()
                .map(entry -> new AppointmentSlot(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Appointment> getApptByPatientId(Integer patientId) {
        List<Appointment> appointments = appointmentRepository.getApptByPatientId(patientId);
        
        
        Map<String, List<AppointmentDetails>> appointmentMap = new HashMap<>();

        for (Appointment appointment : appointments) {
            LocalDateTime dateTime = appointment.getAppointmentDateTime();
            String key = dateTime.getDayOfWeek() + " : " + dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            appointmentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new AppointmentDetails(
                    dateTime.format(DateTimeFormatter.ofPattern("h:mm a")),
                    appointment.getDoctorid().getName()
            ));
        }
        
        
        return appointmentMap.entrySet()
                .stream()
                .map(entry -> new AppointmentSlot(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}

