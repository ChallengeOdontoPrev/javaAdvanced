package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.ClinicaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_clinica")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String address;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "clinica")
    private List<User> users;

    public Clinica(ClinicaDTO clinicaDTO) {
        this.id = clinicaDTO.getId();
        this.name = clinicaDTO.getName();
        this.cnpj = clinicaDTO.getCnpj();
        this.address = clinicaDTO.getAddress();
        this.phone = clinicaDTO.getPhone();
        this.email = clinicaDTO.getEmail();
    }
}
