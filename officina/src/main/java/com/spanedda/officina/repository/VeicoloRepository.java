package com.spanedda.officina.repository;

import com.spanedda.officina.entity.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeicoloRepository extends JpaRepository<Veicolo, Long> {
}
