package com.ciandt.techlab.solid.repository;

import com.ciandt.techlab.solid.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
}
