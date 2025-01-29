package com.odontoprev.challenge.repositories;

import com.odontoprev.challenge.domain.ProcedureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureTypeRepository extends JpaRepository<ProcedureType, Long> {
}
