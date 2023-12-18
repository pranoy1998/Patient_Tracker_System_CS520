package com.fivetwenty.patienttracker.response;

import java.util.List;

public class DoctorScheduleResponse {
    private String id;
    private List<DoctorScheduleSlot> value;

    public List<DoctorScheduleSlot> getValue() {
        return value;
    }

    public void setValue(List<DoctorScheduleSlot> value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
