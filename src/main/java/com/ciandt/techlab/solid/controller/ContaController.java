package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.model.Conta;
import com.ciandt.techlab.solid.repository.ContaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaRepository contaRepository;

    @GetMapping
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    @PostMapping
    public Conta save(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }
}
