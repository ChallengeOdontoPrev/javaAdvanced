package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.ProcedureStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProcedureStatusRepository extends JpaRepository<ProcedureStatus, Long> {
    @Query("SELECT ps FROM ProcedureStatus ps WHERE ps.name = :name")
    Optional<ProcedureStatus> findByName(String name);
}
