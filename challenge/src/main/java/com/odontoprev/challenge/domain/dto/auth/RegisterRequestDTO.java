package com.odontoprev.challenge.domain.dto.auth;

import com.odontoprev.challenge.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RegisterRequestDTO {
    @NotBlank(message = "Nome é obrigatório")
    public String name;
    @NotBlank(message = "Email é obrigatório")
    public String email;
    @NotBlank(message = "RG é obrigatório")
    public String rg;
    @NotNull(message = "Data de nascimento é obrigatória")
    public LocalDate birthDate;
    @NotBlank(message = "Senha é obrigatória")
    public String password;
    @NotNull(message = "A função/papel é obrigatória")
    UserRole role;
    public String cro;
    @NotNull(message = "O id da clínica é obrigatório")
    public Long clinicId;

    public RegisterRequestDTO() {
    }

    public RegisterRequestDTO(String name, String email, String rg, LocalDate birthDate, String password, UserRole role, String cro, Long clinicId) {
        this.name = name;
        this.email = email;
        this.rg = rg;
        this.birthDate = birthDate;
        this.password = password;
        this.role = role;
        this.cro = cro;
        this.clinicId = clinicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }
}
