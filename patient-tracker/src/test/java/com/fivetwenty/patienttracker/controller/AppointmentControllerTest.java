package com.fivetwenty.patienttracker.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import com.fivetwenty.patienttracker.response.DoctorScheduleResponse;
import com.fivetwenty.patienttracker.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppointmentControllerTest {

    @Test
    public void testGetPatientsByDoctorId() {
        AppointmentService appointmentService = mock(AppointmentService.class);
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);

        AppointmentController appointmentController = new AppointmentController(appointmentRepository, appointmentService);

        List<Patient> patients = new ArrayList<>(); // Mocking patient data
        when(appointmentService.getPatientsByDoctorId(1)).thenReturn(patients);

        ResponseEntity<List<Patient>> result = appointmentController.getPatientsByDoctorId(1);
        assertEquals(patients, result.getBody());
    }

    @Test
    public void testGetDoctorSchedules() {
        AppointmentService appointmentService = mock(AppointmentService.class);
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);

        AppointmentController appointmentController = new AppointmentController(appointmentRepository, appointmentService);

        List<DoctorScheduleResponse> schedules = new ArrayList<>(); // Mocking schedules data
        when(appointmentService.getDoctorSchedules(1)).thenReturn(schedules);

        ResponseEntity<List<DoctorScheduleResponse>> result = appointmentController.getDoctorSchedules(1);
        assertEquals(schedules, result.getBody());
    }
}
