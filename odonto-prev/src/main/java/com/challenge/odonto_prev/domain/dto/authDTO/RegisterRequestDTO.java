package com.challenge.odonto_prev.domain.dto.authDTO;

import com.challenge.odonto_prev.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotBlank(message = "Email é obrigatório")
        String email,
        @NotBlank(message = "RG é obrigatório")
        String rg,
        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate birthDate,
        @NotBlank(message = "Senha é obrigatória")
        String password,
        @NotNull(message = "A função/papel é obrigatória")
        UserRole role,
        String cro,
        @NotNull(message = "O id da clínica é obrigatório")
        Long clinicId
) {
}
