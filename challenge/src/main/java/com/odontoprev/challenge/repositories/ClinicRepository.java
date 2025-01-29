package com.odontoprev.challenge.repositories;

import com.odontoprev.challenge.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
