package com.odontoprev.challenge.domain.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterResponseDTO {
    @NotBlank
    public String email;
    @NotBlank
    public String name;
}
