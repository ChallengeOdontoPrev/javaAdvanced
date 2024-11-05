package com.challenge.odonto_prev.domain.dto.authDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResponseDTO {
    @NotBlank
    public String email;
    @NotBlank
    public String name;
}
