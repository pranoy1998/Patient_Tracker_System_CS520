package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.MedicalRecord;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.PatientRepository;
import com.fivetwenty.patienttracker.response.DoctorAppointmentResponse;
import com.fivetwenty.patienttracker.response.PatientDetailsResponse;
import com.fivetwenty.patienttracker.service.AppointmentService;
import com.fivetwenty.patienttracker.service.MedicalRecordService;
import com.fivetwenty.patienttracker.service.PatientService;
import com.fivetwenty.patienttracker.util.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepository;

    private final PatientService patientService;

    private final MedicalRecordService medicalRecordService;

    private final AppointmentService appointmentService;


    public PatientController(PatientRepository patientRepository, PatientService patientService, MedicalRecordService medicalRecordService,
                             AppointmentService appointmentService) {
        this.medicalRecordService = medicalRecordService;
        this.patientRepository = patientRepository;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/")
    @Secured("Patient")
    public Iterable<Patient> findAllPatients() {
        return this.patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    @Secured({"Patient", "Doctor"})
    public ResponseEntity<PatientDetailsResponse> getPatientDetails(@PathVariable("patientId") int patientId) {
        PatientDetailsResponse patientDetails = medicalRecordService.getPatientDetails(patientId);
        return ResponseEntity.ok(patientDetails);
    }

    @GetMapping("/{patientId}/appointments")
    @Secured("Patient")
    public ResponseEntity<List<DoctorAppointmentResponse>> getDoctorAppointments(@PathVariable("patientid") int patientid) {
        List<DoctorAppointmentResponse> appointments = appointmentService.getDoctorAppointments(patientid);
        return ResponseEntity.ok(appointments);
    }

    @PatchMapping("/{patientId}/patientnotes")
    @Secured("Patient")
    public ResponseEntity<String> updatePatientNotes(
            @PathVariable("patientId") int patientId,
            @RequestBody String editedPatientNotes,
            @RequestHeader("Authorization") String jwtToken
    ) {

        boolean updateResult = medicalRecordService.updatePatientNotes(patientId, editedPatientNotes);

        if (updateResult) {
            return ResponseEntity.ok("Success: Patient notes updated");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure: Unable to update patient notes");
        }
    }
}
