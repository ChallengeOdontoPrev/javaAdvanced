package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
