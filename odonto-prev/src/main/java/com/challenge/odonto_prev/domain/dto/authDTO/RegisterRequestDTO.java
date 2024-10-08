package com.challenge.odonto_prev.domain.dto.authDTO;

import com.challenge.odonto_prev.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequestDTO(
        @NotBlank(message = "Email é obrigatório")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        String password,
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotNull(message = "A função/papel é obrigatória")
        UserRole role,
        String cro,
        @NotNull(message = "O id da clínica é obrigatório")
        Long clinicId
) {
}
