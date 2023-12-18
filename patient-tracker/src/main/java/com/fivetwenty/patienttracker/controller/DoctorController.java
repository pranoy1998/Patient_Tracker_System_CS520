package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.repository.DoctorRepository;
import com.fivetwenty.patienttracker.response.DoctorAppointmentResponse;
import com.fivetwenty.patienttracker.service.AppointmentService;
import com.fivetwenty.patienttracker.service.MedicalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    private final AppointmentService appointmentService;

    private final MedicalRecordService medicalRecordService;

    public DoctorController(DoctorRepository doctorRepository, AppointmentService appointmentService, MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
        this.appointmentService = appointmentService;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/{doctorId}/appointments")
    @Secured("Doctor")
    public ResponseEntity<List<DoctorAppointmentResponse>> getDoctorAppointments(@PathVariable("doctorId") int doctorId) {
        List<DoctorAppointmentResponse> appointments = appointmentService.getDoctorAppointments(doctorId);
        return ResponseEntity.ok(appointments);
    }

    @PatchMapping("/{patientid}/doctornotes")
    @Secured("Doctor")
    public ResponseEntity<String> updatePatientNotes(
            @PathVariable("patientid") int patientid,
            @RequestBody String editedDoctorNotes,
            @RequestHeader("Authorization") String jwtToken
    ) {

        boolean updateResult = medicalRecordService.updateDoctorNotes(patientid, editedDoctorNotes);

        if (updateResult) {
            return ResponseEntity.ok("Success: Patient notes updated");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure: Unable to update patient notes");
        }
    }


}