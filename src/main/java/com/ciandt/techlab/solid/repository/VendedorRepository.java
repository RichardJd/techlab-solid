package com.ciandt.techlab.solid.repository;

import com.ciandt.techlab.solid.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
