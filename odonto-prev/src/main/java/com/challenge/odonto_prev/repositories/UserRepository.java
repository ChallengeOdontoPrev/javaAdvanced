package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.User;
import com.challenge.odonto_prev.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = """
            SELECT * FROM tb_user WHERE email = :email
            """)
    Optional<User> findByEmail(String email);

    Optional<User> findByRole(UserRole role);
}
