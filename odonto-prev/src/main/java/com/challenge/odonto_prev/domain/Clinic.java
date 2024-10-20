package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.ClinicDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
