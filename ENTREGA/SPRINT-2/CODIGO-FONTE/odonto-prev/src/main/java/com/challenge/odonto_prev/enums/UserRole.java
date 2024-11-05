package com.challenge.odonto_prev.enums;

public enum UserRole {
    DENTISTA("DENTISTA"),
    ATENDENTE("ATENDENTE"),
    ADMIN("ADMIN");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}
