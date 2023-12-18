package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.MedicalRecord;
import com.fivetwenty.patienttracker.repository.MedicalRecordRepository;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import com.fivetwenty.patienttracker.response.PatientDetailsResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    private final PatientRepository patientRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository, PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public PatientDetailsResponse getPatientDetails(int patientid) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(patientid).orElse(null);
        return mapPatientToResponse(medicalRecord, patientid);
    }

    private PatientDetailsResponse mapPatientToResponse(MedicalRecord medicalRecord, int patientId) {
        PatientDetailsResponse patientDetailsResponse = new PatientDetailsResponse();
        if (medicalRecord != null) {
            if (patientRepository.findByPatientid(patientId) != null)
            {
                patientDetailsResponse.setFullName(patientRepository.findByPatientid(patientId).getName());
                patientDetailsResponse.setAge(calculateAge(patientRepository.findByPatientid(patientId).getDateofbirth()));
                patientDetailsResponse.setPatientId(patientRepository.findByPatientid(patientId).getPatientid());
                // Set additional medical information from the patient entity
                patientDetailsResponse.setMedicalHistory(medicalRecord.getMedicalHistory());
                patientDetailsResponse.setCurrentMedications(medicalRecord.getCurrentMedication());
                patientDetailsResponse.setPreviousDiagnosis(medicalRecord.getPreviousDiagnosis());
                patientDetailsResponse.setDoctorNotes(medicalRecord.getDoctorNotes());
                patientDetailsResponse.setPatientNotes(medicalRecord.getPatientNotes());
            }
            }

        return patientDetailsResponse;
    }

    // Helper method to calculate age based on Date of Birth
    private int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    public boolean updatePatientNotes(int patientId, String editedPatientNotes) {
        try {
            MedicalRecord medicalRecord = medicalRecordRepository.findByPatientPatientid(patientId);
            if (medicalRecord != null) {
                medicalRecord.setPatientNotes(editedPatientNotes);
                medicalRecordRepository.save(medicalRecord);
                return true;
            }
        } catch (Exception e) {
            // Handle exceptions/log errors (e.g., database errors)
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDoctorNotes(int patientid, String editedDoctorNotes) {
        try {
            MedicalRecord medicalRecord = medicalRecordRepository.findByPatientPatientid(patientid);
            if (medicalRecord != null) {
                medicalRecord.setDoctorNotes(editedDoctorNotes);
                medicalRecordRepository.save(medicalRecord);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
