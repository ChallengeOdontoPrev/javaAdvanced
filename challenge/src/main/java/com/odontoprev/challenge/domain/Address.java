package com.odontoprev.challenge.domain;


import com.odontoprev.challenge.domain.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Address(AddressDTO addressDTO) {
        this.id = addressDTO.getId();
        this.street = addressDTO.getStreet();
        this.num = addressDTO.getNumber();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zipCode = addressDTO.getZipCode();
    }
}
