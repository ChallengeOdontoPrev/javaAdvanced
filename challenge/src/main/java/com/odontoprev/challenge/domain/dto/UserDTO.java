package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.User;
import com.odontoprev.challenge.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    @NotBlank
    private String name;
    private String rg;
    private LocalDate birthDate;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private UserRole role;
    private String cro;
    private Long clinicId;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String rg, LocalDate birthDate, String email, String password, UserRole role, String cro, Long clinicId) {
        this.id = id;
        this.name = name;
        this.rg = rg;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cro = cro;
        this.clinicId = clinicId;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.rg = user.getRg();
        this.birthDate = user.getBirthDate();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.cro = user.getCro();
        this.clinicId = user.getClinic().getId();
    }

    public UserDTO(String name, String email, String rg, LocalDate birthDate, String password, UserRole role, String cro, Long clinicId) {
        this.name = name;
        this.email = email;
        this.rg = rg;
        this.birthDate = birthDate;
        this.password = password;
        this.role = role;
        this.cro = cro;
        this.clinicId = clinicId;
    }

    public UserDTO(String name, String email, String rg, LocalDate birthDate, String password, UserRole role, Long clinicId) {
        this.name = name;
        this.email = email;
        this.rg = rg;
        this.birthDate = birthDate;
        this.password = password;
        this.role = role;
        this.clinicId = clinicId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
