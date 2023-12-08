package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.MedicalRecord;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Integer> {
    List<MedicalRecord> findByPatientid(Integer patientid);
}
