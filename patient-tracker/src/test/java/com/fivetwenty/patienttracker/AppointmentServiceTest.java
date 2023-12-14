import com.fivetwenty.patienttracker.model.Appointment;
import com.fivetwenty.patienttracker.model.Doctor;
import com.fivetwenty.patienttracker.model.Patient;
import com.fivetwenty.patienttracker.repository.AppointmentRepository;
import com.fivetwenty.patienttracker.service.AppointmentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPatientsByDoctorId() {
        int doctorId = 1;
        List<Appointment> appointments = Arrays.asList(
                new Appointment(new Doctor(doctorId), new Patient(1), LocalDateTime.now()),
                new Appointment(new Doctor(doctorId), new Patient(2), LocalDateTime.now())
        );
        when(appointmentRepository.findByDoctorDoctorid(doctorId)).thenReturn(appointments);
        List<Patient> patients = appointmentService.getPatientsByDoctorId(doctorId);

        assertEquals(2, patients.size());
        assertEquals(1, patients.get(0).getPatientId()); 
        assertEquals(2, patients.get(1).getPatientId());
    }

    @Test
    void testGetDoctorByPatientId() {
        int patientId = 1;
        List<Appointment> appointments = Arrays.asList(
                new Appointment(new Doctor(1), new Patient(patientId), LocalDateTime.now()),
                new Appointment(new Doctor(2), new Patient(patientId), LocalDateTime.now())
        );
        when(appointmentRepository.findByPatientid(patientId)).thenReturn(appointments);

        List<Doctor> doctors = appointmentService.getDoctorByPatientId(patientId);

        assertEquals(2, doctors.size());
    }

    @Test
    void testGetApptByDoctorId() {
        int doctorId = 1;
        List<Appointment> appointments = Arrays.asList(
                new Appointment(new Doctor(doctorId), new Patient(1), LocalDateTime.now()),
                new Appointment(new Doctor(doctorId), new Patient(2), LocalDateTime.now())
        );
        when(appointmentRepository.getApptByDoctorId(doctorId)).thenReturn(appointments);

        List<Appointment> doctorAppointments = appointmentService.getApptByDoctorId(doctorId);

        assertEquals(2, doctorAppointments.size());
    }

    @Test
    void testGetApptByPatientId() {
       
        int patientId = 1;
        List<Appointment> appointments = Arrays.asList(
                new Appointment(new Doctor(1), new Patient(patientId), LocalDateTime.now()),
                new Appointment(new Doctor(2), new Patient(patientId), LocalDateTime.now())
        );
        when(appointmentRepository.getApptByPatientId(patientId)).thenReturn(appointments);
        
        List<Appointment> patientAppointments = appointmentService.getApptByPatientId(patientId);

        
        assertEquals(2, patientAppointments.size());
    }

}

