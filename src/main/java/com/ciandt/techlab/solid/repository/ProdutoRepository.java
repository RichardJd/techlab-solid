package com.ciandt.techlab.solid.repository;

import com.ciandt.techlab.solid.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
