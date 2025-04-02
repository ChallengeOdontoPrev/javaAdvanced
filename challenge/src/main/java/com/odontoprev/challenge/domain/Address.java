package com.odontoprev.challenge.domain;


import com.odontoprev.challenge.domain.dto.AddressDTO;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String num;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Clinic clinic;

    public Address() {
    }

    public Address(Long id, String street, String num, String city, String state, String zipCode, Clinic clinic) {
        this.id = id;
        this.street = street;
        this.num = num;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.clinic = clinic;
    }

    public Address(AddressDTO addressDTO) {
        this.id = addressDTO.getId();
        this.street = addressDTO.getStreet();
        this.num = addressDTO.getNumber();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zipCode = addressDTO.getZipCode();
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
}
