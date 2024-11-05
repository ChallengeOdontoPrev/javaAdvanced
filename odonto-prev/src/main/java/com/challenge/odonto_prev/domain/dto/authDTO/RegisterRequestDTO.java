package com.challenge.odonto_prev.domain.dto.authDTO;

import com.challenge.odonto_prev.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
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
