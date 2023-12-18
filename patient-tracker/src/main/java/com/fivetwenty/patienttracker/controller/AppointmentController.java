package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import com.fivetwenty.patienttracker.response.DoctorAppointmentResponse;
import com.fivetwenty.patienttracker.response.DoctorScheduleResponse;
import com.fivetwenty.patienttracker.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentRepository appointmentRepository, AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/{doctorid}/patients")
    @Secured("Doctor")
    public ResponseEntity<List<Patient>> getPatientsByDoctorId(@PathVariable Integer doctorid) {
        List<Patient> user = appointmentService.getPatientsByDoctorId(doctorid);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{doctorId}/schedules")
    @Secured("Doctor")
    public ResponseEntity<List<DoctorScheduleResponse>> getDoctorSchedules(@PathVariable("doctorId") int doctorId) {
        List<DoctorScheduleResponse> schedules = appointmentService.getDoctorSchedules(doctorId);
        return ResponseEntity.ok(schedules);
    }


}
