package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.helper.CalculaHelper;
import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.repository.FuncionarioRepository;
import java.util.List;
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

    private final CalculaHelper calculaHelper;
    private final FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/{id}/bonificacao")
    public Double obterSalarioBonificado(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();

        return calculaHelper.calculaSalarioComBonificacao(funcionario);
    }

//    @GetMapping("/{id}/bonificacao/comissao")
//    public Double obterSalarioBonificadoComComissao(@PathVariable Long id) {
//        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
//
//        return calculaHelper.calculaSalarioComBonificacaoEComissao(funcionario);
//    }
}
