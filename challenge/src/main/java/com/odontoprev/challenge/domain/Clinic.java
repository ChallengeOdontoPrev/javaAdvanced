package com.odontoprev.challenge.domain;

import com.odontoprev.challenge.domain.dto.ClinicDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "clinic")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "clinic")
    private List<User> users;

    public Clinic(ClinicDTO clinicDTO) {
        this.id = clinicDTO.getId();
        this.name = clinicDTO.getName();
        this.cnpj = clinicDTO.getCnpj();
        this.phone = clinicDTO.getPhone();
        this.email = clinicDTO.getEmail();
    }
}
