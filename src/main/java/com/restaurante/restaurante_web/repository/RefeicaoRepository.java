package com.restaurante.restaurante_web.repository;

import com.restaurante.restaurante_web.model.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
}
