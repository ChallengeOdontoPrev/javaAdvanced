package com.odontoprev.challenge.enums;

public enum ClassDetected {
    SEM_APARELHO("SEM_APARELHO"),
    APARELHO("APARELHO");

    private final String role;

    ClassDetected(String role) {
        this.role = role;
    }
}
