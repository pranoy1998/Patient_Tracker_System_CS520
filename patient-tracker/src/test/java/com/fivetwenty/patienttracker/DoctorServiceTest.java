package test.java.com.fivetwenty.patienttracker;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    void testGetAllDoctors() {
        
        List<Doctor> doctors = Arrays.asList(
                new Doctor(1, "Dr. John Doe"),
                new Doctor(2, "Dr. Jane Smith")
        );
        when(doctorRepository.findAll()).thenReturn(doctors);

      
        Iterable<Doctor> allDoctors = doctorService.getAllDoctors();

        assertEquals(doctors, allDoctors);
    }

    @Test
    void testGetDoctorById() {
        Doctor doctor = new Doctor(1, "Dr. John Doe");
        when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));

        Doctor retrievedDoctor = doctorService.getDoctorById(1);

        assertEquals(doctor, retrievedDoctor);
    }

    @Test
    void testGetPatientsByDoctorId() {
        Long doctorId = 1L;
        Doctor doctor = new Doctor(doctorId, "Dr. John Doe");
        Patient patient1 = new Patient(1, "Patient A");
        Patient patient2 = new Patient(2, "Patient B");
        Appointment appointment1 = new Appointment(doctor, patient1);
        Appointment appointment2 = new Appointment(doctor, patient2);
        doctor.setAppointments(Arrays.asList(appointment1, appointment2));

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));

        List<Patient> patients = doctorService.getPatientsByDoctorId(doctorId);

        assertEquals(2, patients.size());
        assertEquals(patient1, patients.get(0));
        assertEquals(patient2, patients.get(1));
    }

    @Test
    void testGetPatientsByDoctorIdDoctorNotFound() {
        Long doctorId = 1L;
        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> doctorService.getPatientsByDoctorId(doctorId));
    }
}
