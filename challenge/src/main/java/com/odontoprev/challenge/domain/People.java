package com.odontoprev.challenge.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate createdAt;
    @Column(unique = true)
    private String rg;
    private LocalDate birthDate;

    public People() {
    }

    public People(Long id, String name, LocalDate createdAt, String rg, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.rg = rg;
        this.birthDate = birthDate;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
