package com.restaurante.restaurante_web.repository;

import com.restaurante.restaurante_web.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}
