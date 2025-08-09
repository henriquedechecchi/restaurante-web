package com.restaurante.restaurante_web.repository;

import com.restaurante.restaurante_web.model.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}
