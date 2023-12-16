package com.fivetwenty.patienttracker.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private int patientid;
    private LocalDate dateofbirth;
    private String name;
    private String contactinformation;
    private String email;

    public Patient() {
        // Empty constructor
    }

    public Patient(int patientid, LocalDate dateofbirth, String name, String contactinformation, String email) {
        this.patientid = patientid;
        this.dateofbirth = dateofbirth;
        this.name = name;
        this.contactinformation = contactinformation;
        this.email = email;
    }

    // Getters and setters for all fields

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(String contactinformation) {
        this.contactinformation = contactinformation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString() method to represent object details

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientid +
                ", dateOfBirth=" + dateofbirth +
                ", name='" + name + '\'' +
                ", contactInformation='" + contactinformation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

