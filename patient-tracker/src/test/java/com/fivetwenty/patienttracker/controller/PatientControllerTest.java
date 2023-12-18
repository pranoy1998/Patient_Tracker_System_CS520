package com.fivetwenty.patienttracker.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import com.fivetwenty.patienttracker.response.DoctorAppointmentResponse;
import com.fivetwenty.patienttracker.response.PatientDetailsResponse;
import com.fivetwenty.patienttracker.service.AppointmentService;
import com.fivetwenty.patienttracker.service.MedicalRecordService;
import com.fivetwenty.patienttracker.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PatientControllerTest {

    @Test
    public void testFindAllPatients() {
        PatientService patientService = mock(PatientService.class);
        PatientRepository patientRepository = mock(PatientRepository.class);
        MedicalRecordService medicalRecordService = mock(MedicalRecordService.class);
        AppointmentService appointmentService = mock(AppointmentService.class);

        PatientController patientController = new PatientController(patientRepository, patientService, medicalRecordService, appointmentService);

        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient()); // Mocking patient data

        when(patientService.getAllPatients()).thenReturn(patients);

        Iterable<Patient> result = patientController.findAllPatients();
        assertEquals(patients, result);
    }

    @Test
    public void testGetPatientDetails() {
        MedicalRecordService medicalRecordService = mock(MedicalRecordService.class);
        PatientRepository patientRepository = mock(PatientRepository.class);
        PatientService patientService = mock(PatientService.class);
        AppointmentService appointmentService = mock(AppointmentService.class);

        PatientController patientController = new PatientController(patientRepository, patientService, medicalRecordService, appointmentService);

        PatientDetailsResponse response = new PatientDetailsResponse(); // Mocking response
        when(medicalRecordService.getPatientDetails(anyInt())).thenReturn(response);

        ResponseEntity<PatientDetailsResponse> result = patientController.getPatientDetails(1);
        assertEquals(response, result.getBody());
    }

    @Test
    public void testGetDoctorAppointments() {
        AppointmentService appointmentService = mock(AppointmentService.class);
        MedicalRecordService medicalRecordService = mock(MedicalRecordService.class);
        PatientRepository patientRepository = mock(PatientRepository.class);
        PatientService patientService = mock(PatientService.class);

        PatientController patientController = new PatientController(patientRepository, patientService, medicalRecordService, appointmentService);

        List<DoctorAppointmentResponse> appointments = new ArrayList<>(); // Mocking appointments data
        when(appointmentService.getDoctorAppointments(anyInt())).thenReturn(appointments);

        ResponseEntity<List<DoctorAppointmentResponse>> result = patientController.getDoctorAppointments(1);
        assertEquals(appointments, result.getBody());
    }

    @Test
    public void testUpdatePatientNotes() {
        MedicalRecordService medicalRecordService = mock(MedicalRecordService.class);
        PatientRepository patientRepository = mock(PatientRepository.class);
        PatientService patientService = mock(PatientService.class);
        AppointmentService appointmentService = mock(AppointmentService.class);

        PatientController patientController = new PatientController(patientRepository, patientService, medicalRecordService, appointmentService);

        String editedPatientNotes = "Updated notes"; // Mocking edited patient notes

        when(medicalRecordService.updatePatientNotes(anyInt(), anyString())).thenReturn(true);

        ResponseEntity<String> result = patientController.updatePatientNotes(1, editedPatientNotes, "jwtToken");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Success: Patient notes updated", result.getBody());
    }
}
