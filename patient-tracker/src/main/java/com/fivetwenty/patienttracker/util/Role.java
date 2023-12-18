package com.fivetwenty.patienttracker.util;

public enum Role {
    DOCTOR("doctor"),
    PATIENT("patient");

    private final String roleString;

    // Constructor
    Role(String roleString) {
        this.roleString = roleString;
    }

    public String getRoleString() {
        return roleString;
    }
}
