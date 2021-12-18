package com.ciandt.techlab.solid.repository;

import com.ciandt.techlab.solid.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
