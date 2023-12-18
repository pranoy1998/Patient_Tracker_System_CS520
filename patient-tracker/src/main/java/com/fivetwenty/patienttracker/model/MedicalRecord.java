package com.fivetwenty.patienttracker.model;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name = "medicalrecord")
public class MedicalRecord {
    @Id
    private int recordid;
    private String patientnotes;
    private String doctornotes;
    private String medicalhistory;
    private int updatedby;
    private String currentmedication;
    private String previousdiagnosis;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patientid")
    private Patient patient;

    private LocalDateTime submissiondate;

    public MedicalRecord(){

    }

    public MedicalRecord(int recordId, String patientNotes, String doctorNotes, byte[] uploadedDocs,
                         String medicalHistory, int updatedBy, String currentMedication,
                         String previousDiagnosis, Patient patient, LocalDateTime submissionDate) {
        this.recordid = recordId;
        this.patientnotes = patientNotes;
        this.doctornotes = doctorNotes;
        this.medicalhistory = medicalHistory;
        this.updatedby = updatedBy;
        this.currentmedication = currentMedication;
        this.previousdiagnosis = previousDiagnosis;
        this.patient = patient;
        this.submissiondate = submissionDate;
    }

    // Getters and setters for all fields

    public int getRecordId() {
        return recordid;
    }

    public void setRecordId(int recordId) {
        this.recordid = recordId;
    }

    public String getPatientNotes() {
        return patientnotes;
    }

    public void setPatientNotes(String patientNotes) {
        this.patientnotes = patientNotes;
    }

    public String getDoctorNotes() {
        return doctornotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctornotes = doctorNotes;
    }

    public String getMedicalHistory() {
        return medicalhistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalhistory = medicalHistory;
    }

    public int getUpdatedBy() {
        return updatedby;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedby = updatedBy;
    }

    public String getCurrentMedication() {
        return currentmedication;
    }

    public void setCurrentMedication(String currentMedication) {
        this.currentmedication = currentMedication;
    }

    public String getPreviousDiagnosis() {
        return previousdiagnosis;
    }

    public void setPreviousDiagnosis(String previousDiagnosis) {
        this.previousdiagnosis = previousDiagnosis;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getSubmissionDate() {
        return submissiondate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissiondate = submissionDate;
    }

    // toString() method to represent object details

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId=" + recordid +
                ", patientNotes='" + patientnotes + '\'' +
                ", doctorNotes='" + doctornotes + '\'' +
                ", medicalHistory='" + medicalhistory + '\'' +
                ", updatedBy=" + updatedby +
                ", currentMedication='" + currentmedication + '\'' +
                ", previousDiagnosis='" + previousdiagnosis + '\'' +
                ", patientId=" + patient.getPatientid() +
                ", submissionDate=" + submissiondate +
                '}';
    }
}
