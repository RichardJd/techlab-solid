package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.dto.FuncionarioDtoRequest;
import com.ciandt.techlab.solid.dto.FuncionarioDtoResponse;
import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository repository;

    @PostMapping
    public Funcionario salvar(@RequestBody FuncionarioDtoRequest funcionarioDtoRequest) {
        return this.repository.save(Funcionario.valueOf(funcionarioDtoRequest));
    }

    @GetMapping("/{id}/bonificacao")
    public FuncionarioDtoResponse obterSalarioBonificado(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow();
        Double salarioComBonificacao = funcionario.calculaSalarioComBonificacao();

        return FuncionarioDtoResponse.valueOf(funcionario, salarioComBonificacao);
    }

    @GetMapping("/{id}/bonificacao-comissao")
    public FuncionarioDtoResponse obterSalarioBonificadoEComissionado(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow();
        Double salarioComBonificacao = funcionario.calculaSalarioComBonificacaoEComissao();

        return FuncionarioDtoResponse.valueOf(funcionario, salarioComBonificacao);
    }

    @GetMapping("/{id}/bonificacao-extras")
    public FuncionarioDtoResponse obterSalarioBonificadoComExtras(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow();
        Double salarioComBonificacao = funcionario.calculaSalarioComHorasExtras();

        return FuncionarioDtoResponse.valueOf(funcionario, salarioComBonificacao);
    }
}
