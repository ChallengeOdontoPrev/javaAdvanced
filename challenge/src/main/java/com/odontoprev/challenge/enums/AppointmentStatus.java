package com.odontoprev.challenge.enums;

public enum AppointmentStatus {
    SCHEDULED("SCHEDULED"),
    FINISHED("FINISHED");

    private final String code;

    AppointmentStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

