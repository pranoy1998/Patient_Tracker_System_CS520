package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import com.fivetwenty.patienttracker.service.PatientService;
import com.fivetwenty.patienttracker.util.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PatientController {

    private final PatientRepository patientRepository;

    private final PatientService patientService;

    public PatientController(PatientRepository patientRepository, PatientService patientService) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public Iterable<Patient> findAllPatients() {
        return this.patientService.getAllPatients();
    }

    @GetMapping("patient/{patientid}")
//    @Secured("doctor")
    public ResponseEntity<Patient> getUserById(@PathVariable Integer patientid) {
        Patient user = patientService.getPatientById(patientid);
        return ResponseEntity.ok().body(user);
    }
}
