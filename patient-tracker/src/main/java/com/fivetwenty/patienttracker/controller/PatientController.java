package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import com.fivetwenty.patienttracker.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientRepository patientRepository;

    private final PatientService patientService;

    public PatientController(PatientRepository patientRepository, PatientService patientService) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }

    @GetMapping("/patient")
    public Iterable<Patient> findAllEmployees() {
        return this.patientService.getAllPatients();
    }

    @GetMapping("patient/{patientid}")
    public ResponseEntity<Patient> getUserById(@PathVariable Integer patientid) {
        Patient user = patientService.getPatientById(patientid);
        return ResponseEntity.ok().body(user);
    }
}
