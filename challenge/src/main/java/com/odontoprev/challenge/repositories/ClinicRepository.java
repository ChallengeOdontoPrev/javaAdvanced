package com.odontoprev.challenge.repositories;

import com.odontoprev.challenge.domain.Clinic;
import com.odontoprev.challenge.domain.projection.AuditProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    @Query(value = """
        SELECT audit_id AS auditId, operation, changed_by AS changedBy, change_timestamp AS changeTimestamp
        FROM tb_clinic_audit
        """, nativeQuery = true)
    List<AuditProjection> findAllClinicAudits();

}
