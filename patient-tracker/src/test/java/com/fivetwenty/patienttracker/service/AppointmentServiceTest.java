package com.fivetwenty.patienttracker.service;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppointmentServiceTest {

    @Test
    public void testGetPatientsByDoctorId() {
        // Mock AppointmentRepository
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);

        // Create an instance of AppointmentService with the mocked repository
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Mock data for appointments
        Doctor doctor = new Doctor();
        doctor.setDoctorId(1);

        Patient patient1 = new Patient();
        patient1.setName("Patient One");
        patient1.setPatientid(101);

        Patient patient2 = new Patient();
        patient2.setName("Patient Two");
        patient2.setPatientid(102);

        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, LocalDateTime.now(), doctor, patient1));
        appointments.add(new Appointment(2, LocalDateTime.now(), doctor, patient2));

        // Mock repository behavior
        when(appointmentRepository.findByDoctorDoctorid(1)).thenReturn(appointments);

        // Test when appointments exist for the given doctor ID
        List<Patient> patients = appointmentService.getPatientsByDoctorId(1);
        assertEquals(2, patients.size());
        assertEquals("Patient One", patients.get(0).getName());
        assertEquals("Patient Two", patients.get(1).getName());

        // Test when no appointments exist for the given doctor ID
        when(appointmentRepository.findByDoctorDoctorid(2)).thenReturn(new ArrayList<>());
        patients = appointmentService.getPatientsByDoctorId(2);
        assertTrue(patients.isEmpty());
    }

}
