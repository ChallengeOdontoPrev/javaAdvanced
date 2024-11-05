package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.ProcedureStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProcedureStatusRepository extends JpaRepository<ProcedureStatus, Long> {
    @Query("SELECT ps FROM ProcedureStatus ps WHERE ps.name = :name")
    Optional<ProcedureStatus> findByName(String name);

    @Procedure(name = "INSERT_PROCEDURE_STATUS")
    void INSERT_PROCEDURE_STATUS(
            @Param("p_name") String name,
            @Param("p_description") String description
    );

    @Procedure(name = "UPDATE_PROCEDURE_STATUS")
    void UPDATE_PROCEDURE_STATUS(
            @Param("p_id") Long id,
            @Param("p_name") String name,
            @Param("p_description") String description
    );

    @Procedure(name = "DELETE_PROCEDURE_STATUS")
    void DELETE_PROCEDURE_STATUS(@Param("p_id") Long id);
}
