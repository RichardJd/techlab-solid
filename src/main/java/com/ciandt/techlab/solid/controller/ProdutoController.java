package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.model.Produto;
import com.ciandt.techlab.solid.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        if("Data preenchida incorretamente".equals(produto.validarDataCadastro(produto.getDataCadastro()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(produto));
    }
}
