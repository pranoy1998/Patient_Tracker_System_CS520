package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import com.fivetwenty.patienttracker.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<Patient>> getPatientsByDoctorId(@PathVariable Integer doctorid) {
        List<Patient> user = appointmentService.getPatientsByDoctorId(doctorid);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("doctorByPatient/{patientid}")
    public ResponseEntity<List<Doctor>> getDoctorByPatientId(@PathVariable Integer patientid) {
        List<Doctor> user = appointmentService.getDoctorsByPatientId(patientid);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentSlot>> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        try {
            List<AppointmentSlot> appointmentSlots = appointmentService.getApptByDoctorId(doctorId);
            return new ResponseEntity<>(appointmentSlots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentSlot>> getAppointmentsTodayByDoctorId(@PathVariable Long doctorId) {
        try {
            List<AppointmentSlot> appointmentSlots = appointmentService.getApptTodayByDoctorId(doctorId);
            return new ResponseEntity<>(appointmentSlots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentSlot>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        try {
            List<AppointmentSlot> appointmentSlots = appointmentService.getApptByPatientId(patientId);
            return new ResponseEntity<>(appointmentSlots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentSlot>> getAppointmentsTodayByPatientId(@PathVariable Long patientId) {
        try {
            List<AppointmentSlot> appointmentSlots = appointmentService.getApptTodayByPatientId(patientId);
            return new ResponseEntity<>(appointmentSlots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
