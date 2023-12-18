package com.fivetwenty.patienttracker.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.model.Patient;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AppointmentTest {

    @Test
    public void testConstructorAndGetters() {
        // Create a Doctor and a Patient for appointment
        Doctor doctor = new Doctor();
        doctor.setDoctorId(1); // Set Doctor ID
        Patient patient = new Patient();
        patient.setPatientid(2); // Set Patient ID

        // Create an Appointment using the constructor
        LocalDateTime dateTime = LocalDateTime.now();
        Appointment appointment = new Appointment(100, dateTime, doctor, patient);

        // Test the constructor and getters
        assertEquals(100, appointment.getAppointmentId());
        assertEquals(dateTime, appointment.getDatetime());
        assertEquals(doctor, appointment.getDoctorid());
        assertEquals(patient, appointment.getPatient());
    }

    @Test
    public void testSetters() {
        Appointment appointment = new Appointment();

        // Set values using setters
        LocalDateTime dateTime = LocalDateTime.now();
        appointment.setAppointmentId(200);
        appointment.setDatetime(dateTime);

        Doctor doctor = new Doctor();
        doctor.setDoctorId(3);
        appointment.setDoctorid(doctor);

        Patient patient = new Patient();
        patient.setPatientid(4);
        appointment.setPatient(patient);

        assertEquals(dateTime, appointment.getDatetime());
        assertEquals(doctor, appointment.getDoctorid());
        assertEquals(patient, appointment.getPatient());
    }

    @Test
    public void testToString() {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(5);
        Patient patient = new Patient();
        patient.setPatientid(6);

        Appointment appointment = new Appointment(300, LocalDateTime.now(), doctor, patient);

        // Test the toString() method
        String expectedString = "Appointment{appointmentId=300, dateTime=" + appointment.getDatetime() +
                ", doctorId=" + doctor.getDoctorId() + ", patientId=" + patient.getPatientid() + '}';
        assertEquals(expectedString, appointment.toString());
    }
}
