package com.odontoprev.challenge.domain.dto.auth;

import com.odontoprev.challenge.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
