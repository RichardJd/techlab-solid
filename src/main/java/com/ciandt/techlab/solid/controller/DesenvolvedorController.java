package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.helper.calculo.CalculaHelper;
import com.ciandt.techlab.solid.helper.validacao.ValidacaoFuncionario;
import com.ciandt.techlab.solid.model.Desenvolvedor;
import com.ciandt.techlab.solid.repository.DesenvolvedorRepository;
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
@RequestMapping("/desenvolvedores")
public class DesenvolvedorController {

    private final DesenvolvedorRepository repository;

    private final ValidacaoFuncionario validacaoFuncionarioHelper;

    private final CalculaHelper calculaHelper;

    @PostMapping
    public ResponseEntity<Desenvolvedor> salvar(@RequestBody Desenvolvedor desenvolvedor) {
        if("Nome preenchido incorretamente".equals(validacaoFuncionarioHelper.validarNome(desenvolvedor.getNome()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(desenvolvedor));
    }

    @GetMapping("/{id}/bonificacao")
    public Double obterSalarioBonificado(@PathVariable Long id) {
        Desenvolvedor desenvolvedor = repository.findById(id).orElseThrow();
        return calculaHelper.calculaSalarioComBonificacao(desenvolvedor);
    }

    @GetMapping("/{id}/bonificacao-extras")
    public Double obterSalarioBonificadoComExtras(@PathVariable Long id) {
        Desenvolvedor desenvolvedor = repository.findById(id).orElseThrow();
        return calculaHelper.calculaSalarioComBonificacaoEHorasExtras(desenvolvedor);
    }
}
