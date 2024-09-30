package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
