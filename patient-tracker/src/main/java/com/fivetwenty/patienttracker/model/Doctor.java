package com.fivetwenty.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    private int doctorid;
    private int userid; // Reference to UserAccount table
    private String name;
    private String contactinformation;
    private String specialization;

    public Doctor(){

    }

    public Doctor(int doctorid, int userid, String name, String contactinformation, String specialization) {
        this.doctorid = doctorid;
        this.userid = userid;
        this.name = name;
        this.contactinformation = contactinformation;
        this.specialization = specialization;
    }

    // Getters and setters for all fields

    public int getDoctorId() {
        return doctorid;
    }

    public void setDoctorId(int doctorid) {
        this.doctorid = doctorid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString() method to represent object details

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorid +
                ", userId=" + userid +
                ", name='" + name + '\'' +
                ", contactInformation='" + contactinformation + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}

