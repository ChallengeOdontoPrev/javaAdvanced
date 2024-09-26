package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.Clinica;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicaDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    @Email
    private String email;

    public ClinicaDTO(Clinica clinica) {
        this.id = clinica.getId();
        this.name = clinica.getName();
        this.cnpj = clinica.getCnpj();
        this.address = clinica.getAddress();
        this.phone = clinica.getPhone();
        this.email = clinica.getEmail();
    }
}
