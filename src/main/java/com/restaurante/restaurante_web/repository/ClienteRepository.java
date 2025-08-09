package com.restaurante.restaurante_web.repository;

import com.restaurante.restaurante_web.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
