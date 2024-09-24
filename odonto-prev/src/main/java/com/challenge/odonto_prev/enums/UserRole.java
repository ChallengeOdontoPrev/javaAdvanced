package com.challenge.odonto_prev.enums;

public enum UserRole {
    DENTISTA("DENTISTA"),
    ATENDENTE("ATENDENTE");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
