package com.fivetwenty.patienttracker.model;

import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    private int appointmentid;
    private LocalDateTime datetime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorid")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patientid")
    private Patient patient;


    public Appointment(){

    }

    public Appointment(int appointmentid, LocalDateTime datetime, Doctor doctor, Patient patient) {
        this.appointmentid = appointmentid;
        this.datetime = datetime;
        this.doctor = doctor;
        this.patient = patient;
    }

    // Getters and setters for all fields

    public int getAppointmentId() {
        return appointmentid;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentid = appointmentid;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Doctor getDoctorid() {
        return doctor;
    }

    public void setDoctorid(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // toString() method to represent object details

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentid +
                ", dateTime=" + datetime +
                ", doctorId=" + doctor.getDoctorId() +
                ", patientId=" + patient.getPatientid() +
                '}';
    }
}

