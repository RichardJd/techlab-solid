package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        if("Nome preenchido corretamente".equals(funcionario.validarNome(funcionario.getNome()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(funcionario));
    }

    @GetMapping("/{id}/bonificacao")
    public Double obterSalarioBonificado(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow();
        return funcionario.calculaSalarioComBonificacao();
    }

    @GetMapping("/{id}/bonificacao-comissao")
    public Double obterSalarioBonificadoEComissionado(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow();
        return funcionario.calculaSalarioComBonificacaoEComissao();
    }

    @GetMapping("/{id}/bonificacao-extras")
    public Double obterSalarioBonificadoComExtras(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow();
        return funcionario.calculaSalarioComHorasExtras();
    }
}
