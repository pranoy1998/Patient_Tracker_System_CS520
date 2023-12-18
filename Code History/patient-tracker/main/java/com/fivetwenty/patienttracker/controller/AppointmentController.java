package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import com.fivetwenty.patienttracker.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentRepository appointmentRepository, AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("patientsByDoctor/{doctorid}")
    public ResponseEntity<List<Patient>> getUserById(@PathVariable Integer doctorid) {
        List<Patient> user = appointmentService.getPatientsByDoctorId(doctorid);
        return ResponseEntity.ok().body(user);
    }


}
