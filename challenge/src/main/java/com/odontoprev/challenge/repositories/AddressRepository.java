package com.odontoprev.challenge.repositories;

import com.odontoprev.challenge.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
