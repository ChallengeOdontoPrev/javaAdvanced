package com.odontoprev.challenge.domain.dto;


import com.odontoprev.challenge.domain.Clinic;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    public ClinicDTO() {
    }

    public ClinicDTO(Clinic clinic) {
        this.id = clinic.getId();
        this.name = clinic.getName();
        this.cnpj = clinic.getCnpj();
        this.phone = clinic.getPhone();
        this.email = clinic.getEmail();
        this.address = new AddressDTO(clinic.getAddress());
    }

    public ClinicDTO(Long id, String name, String cnpj, AddressDTO address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.phone = phone;
        this.email = email;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
