package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.ProcedureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureTypeRepository extends JpaRepository<ProcedureType, Long> {
}
