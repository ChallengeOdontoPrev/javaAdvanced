package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByRg(String rg);
}
