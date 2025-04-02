package com.odontoprev.challenge.repositories;


import com.odontoprev.challenge.domain.User;
import com.odontoprev.challenge.domain.projection.AuditProjection;
import com.odontoprev.challenge.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = """
            SELECT * FROM tb_user WHERE email = :email
            """)
    Optional<User> findByEmail(String email);

    List<User> findByRole(UserRole role);

    @Query(value = """
            SELECT audit_id AS auditId, operation, changed_by AS changedBy, change_timestamp AS changeTimestamp
            FROM tb_user_audit
            """, nativeQuery = true)
    List<AuditProjection> findAllUserAudits();
}
