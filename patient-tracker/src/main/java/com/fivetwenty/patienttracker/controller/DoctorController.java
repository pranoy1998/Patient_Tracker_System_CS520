package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.repository.DoctorRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
}