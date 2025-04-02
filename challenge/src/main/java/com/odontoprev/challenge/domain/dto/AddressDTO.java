package com.odontoprev.challenge.domain.dto;


import com.odontoprev.challenge.domain.Address;
import jakarta.validation.constraints.NotBlank;

public class AddressDTO {
    private Long id;
    @NotBlank(message = "Rua é obrigatória")
    private String street;
    @NotBlank(message = "Número é obrigatório")
    private String number;
    @NotBlank(message = "Cidade é obrigatória")
    private String city;
    @NotBlank(message = "Estado é obrigatório")
    private String state;
    @NotBlank(message = "CEP é obrigatório")
    private String zipCode;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNum();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
    }

    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, String number, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
