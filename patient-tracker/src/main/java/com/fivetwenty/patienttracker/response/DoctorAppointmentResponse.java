package com.fivetwenty.patienttracker.response;

import java.util.List;

public class DoctorAppointmentResponse {
    private String id;
    private List<AppointmentDetails> value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AppointmentDetails> getValue() {
        return value;
    }

    public void setValue(List<AppointmentDetails> value) {
        this.value = value;
    }
}


