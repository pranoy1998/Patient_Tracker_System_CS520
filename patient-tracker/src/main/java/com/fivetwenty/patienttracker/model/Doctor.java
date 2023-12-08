package com.fivetwenty.patienttracker.model;

import org.apache.catalina.User;

import javax.persistence.*;


@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    private int doctorid;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private UserAccount user;

    private String name;
    private String contactinformation;
    private String specialization;

    public Doctor(){

    }

    public Doctor(int doctorid, UserAccount user, String name, String contactinformation, String specialization) {
        this.doctorid = doctorid;
        this.user = user;
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

    public UserAccount getUserid() {
        return user;
    }

    public void setUserid(UserAccount userid) {
        this.user = user;
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
                ", userId=" + user.getUserId() +
                ", name='" + name + '\'' +
                ", contactInformation='" + contactinformation + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}

