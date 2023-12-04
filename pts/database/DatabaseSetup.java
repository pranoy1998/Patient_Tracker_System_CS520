package database;//psql -U vaishnavishah -d patient_doctor
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSetup {

    public static void main(String[] args) {
        DatabaseConnection.setupDatabase();
        
        try (Connection connection = DriverManager.getConnection(DatabaseConnection.jdbcUrl)) {
            // Create tables
            createTable(connection, "UserAccount", "CREATE TABLE UserAccount (UserId SERIAL PRIMARY KEY, Username VARCHAR(50) NOT NULL, Password VARCHAR(50) NOT NULL, Role VARCHAR(20) NOT NULL)");
            createTable(connection, "Doctor", "CREATE TABLE Doctor (DoctorId SERIAL PRIMARY KEY, UserId INT REFERENCES UserAccount(UserId), Name VARCHAR(100) NOT NULL, ContactInformation VARCHAR(100), Specialization VARCHAR(50))");
            createTable(connection, "Appointment", "CREATE TABLE Appointment (AppointmentId SERIAL PRIMARY KEY, DateTime TIMESTAMP NOT NULL, DoctorId INT REFERENCES Doctor(DoctorId), PatientId INT REFERENCES Patient(PatientId))");
            createTable(connection, "Patient", "CREATE TABLE Patient (PatientId SERIAL PRIMARY KEY, DateOfBirth DATE, Name VARCHAR(100) NOT NULL, ContactInformation VARCHAR(100), Email VARCHAR(100))");
            createTable(connection, "MedicalRecord", "CREATE TABLE MedicalRecord (RecordId SERIAL PRIMARY KEY, PatientNotes TEXT, DoctorNotes TEXT, UploadedDocs BYTEA, MedicalHistory TEXT, UpdatedBy INT REFERENCES Doctor(DoctorId), CurrentMedication TEXT, PreviousDiagnosis TEXT, PatientId INT REFERENCES Patient(PatientId), SubmissionDate TIMESTAMP)");

            System.out.println("Database schema created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection, String tableName, String createTableSQL) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table " + tableName + " created successfully.");
        }
    }
}
