package com.fivetwenty.patienttracker.model;

import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    private int appointmentid;
    private LocalDateTime datetime;
    private int doctorid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patientid")
    private Patient patient;

    public Appointment(){

    }

    public Appointment(int appointmentid, LocalDateTime datetime, int doctorid, Patient patientid) {
        this.appointmentid = appointmentid;
        this.datetime = datetime;
        this.doctorid = doctorid;
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

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public Patient getPatientid() {
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
                ", doctorId=" + doctorid +
                ", patientId=" + patient.getPatientid() +
                '}';
    }
}

