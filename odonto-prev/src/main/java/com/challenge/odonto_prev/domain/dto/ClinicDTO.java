package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.Address;
import com.challenge.odonto_prev.domain.Clinic;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String cnpj;
    @NotNull
    private AddressDTO address;
    @NotBlank
    private String phone;
    @NotBlank
    @Email
    private String email;

    public ClinicDTO(Clinic clinic) {
        this.id = clinic.getId();
        this.name = clinic.getName();
        this.cnpj = clinic.getCnpj();
        this.phone = clinic.getPhone();
        this.email = clinic.getEmail();
        this.address = new AddressDTO(clinic.getAddress());
    }
}
