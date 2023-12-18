package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import com.fivetwenty.patienttracker.response.AppointmentDetails;
import com.fivetwenty.patienttracker.response.DoctorAppointmentResponse;
import com.fivetwenty.patienttracker.response.DoctorScheduleResponse;
import com.fivetwenty.patienttracker.response.DoctorScheduleSlot;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
                .map(Appointment::getPatient)
                .collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsForDoctor(Doctor doctor) {
        return appointmentRepository.findByDoctor(doctor);
    }

    public List<DoctorScheduleResponse> getDoctorSchedules(int doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorDoctorid(doctorId);
        return mapSchedulesToResponse(appointments);
    }

    private List<DoctorScheduleResponse> mapSchedulesToResponse(List<Appointment> appointments) {
        List<DoctorScheduleResponse> doctorSchedules = new ArrayList<>();

        // Group appointments by date for easier processing
        Map<LocalDate, List<Appointment>> appointmentsByDate = appointments.stream()
                .collect(Collectors.groupingBy(appointment -> appointment.getDatetime().toLocalDate()));

        appointmentsByDate.forEach((date, appointmentsOnDate) -> {
            DoctorScheduleResponse doctorScheduleResponse = new DoctorScheduleResponse();
            doctorScheduleResponse.setId(date.getDayOfWeek().toString() + " : " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            List<DoctorScheduleSlot> scheduleSlots = new ArrayList<>();
            appointmentsOnDate.forEach(appointment -> {
                DoctorScheduleSlot slot = new DoctorScheduleSlot();
                slot.setTime(formatTimeSlot(appointment.getDatetime()));
                slot.setPatientName(appointment.getPatient().getName());
                slot.setPatientId(String.valueOf(appointment.getPatient().getPatientid()));
                scheduleSlots.add(slot);
            });

            doctorScheduleResponse.setValue(scheduleSlots);
            doctorSchedules.add(doctorScheduleResponse);
        });

        return doctorSchedules;
    }

    private String formatTimeSlot(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("ha")) + " - " +
                dateTime.plusHours(1).format(DateTimeFormatter.ofPattern("ha"));
    }

    public List<DoctorAppointmentResponse> getDoctorAppointments(int doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorDoctorid(doctorId);
        return mapAppointmentsToResponse(appointments);
    }

    private List<DoctorAppointmentResponse> mapAppointmentsToResponse(List<Appointment> appointments) {
        Map<LocalDate, List<Appointment>> appointmentsByDate = appointments.stream()
                .collect(Collectors.groupingBy(appointment -> appointment.getDatetime().toLocalDate()));

        List<DoctorAppointmentResponse> doctorAppointments = new ArrayList<>();

        appointmentsByDate.forEach((date, appointmentsOnDate) -> {
            DoctorAppointmentResponse doctorAppointmentResponse = new DoctorAppointmentResponse();
            doctorAppointmentResponse.setId(date.getDayOfWeek().toString() + " : " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            List<AppointmentDetails> appointmentDetailsList = new ArrayList<>();
            appointmentsOnDate.forEach(appointment -> {
                AppointmentDetails appointmentDetails = new AppointmentDetails();
                appointmentDetails.setTime(formatTimeSlot(appointment.getDatetime()));
                appointmentDetails.setPatientName(appointment.getPatient().getName());
                appointmentDetails.setPatientId(String.valueOf(appointment.getPatient().getPatientid()));
                appointmentDetailsList.add(appointmentDetails);
            });

            doctorAppointmentResponse.setValue(appointmentDetailsList);
            doctorAppointments.add(doctorAppointmentResponse);
        });

        return doctorAppointments;
    }

}

