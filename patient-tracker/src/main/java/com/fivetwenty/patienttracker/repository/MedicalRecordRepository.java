package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Integer> {
    MedicalRecord findByPatientPatientid(int patientid);
}
