package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
