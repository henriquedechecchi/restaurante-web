package com.restaurante.restaurante_web.repository;

import com.restaurante.restaurante_web.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
