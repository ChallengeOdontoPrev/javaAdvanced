package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
