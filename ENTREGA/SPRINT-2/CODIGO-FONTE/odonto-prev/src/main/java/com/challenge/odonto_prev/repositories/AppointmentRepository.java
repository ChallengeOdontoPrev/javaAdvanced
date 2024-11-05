package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(nativeQuery = true, value = """
            SELECT ap.*
            FROM tb_appointment ap
            JOIN tb_procedure_validation pv
            ON pv.id = ap.procedure_validation_id
            JOIN tb_procedure_status ps
            ON ps.id = pv.procedure_status_id
            WHERE ps.name = :status
            """)
    List<Appointment> findAllByStatus(String status);
}