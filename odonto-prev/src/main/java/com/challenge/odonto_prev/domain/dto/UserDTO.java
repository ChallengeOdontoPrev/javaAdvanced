package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.User;
import com.challenge.odonto_prev.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private UserRole role;
    private String cro;
    private Long clinicId;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.cro = user.getCro();
        this.clinicId = user.getClinic().getId();
    }

    public UserDTO(String name, String email, String password, UserRole role, String cro, Long clinicId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cro = cro;
        this.clinicId = clinicId;
    }

    public UserDTO(String name, String email, String password, UserRole role, Long clinicId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.clinicId = clinicId;
    }
}
