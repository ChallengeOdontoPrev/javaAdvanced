package com.odontoprev.challenge.domain;

import com.odontoprev.challenge.domain.dto.ClinicDTO;
import jakarta.persistence.*;

import java.util.List;

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

    public Clinic() {
    }

    public Clinic(Long id, String name, String cnpj, String phone, String email, Address address, List<Appointment> appointments, List<User> users) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.appointments = appointments;
        this.users = users;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
