package com.challenge.odonto_prev.repositories;

import com.challenge.odonto_prev.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
