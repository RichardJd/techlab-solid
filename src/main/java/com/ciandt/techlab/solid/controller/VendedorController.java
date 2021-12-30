package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.helper.calculo.CalculaHelper;
import com.ciandt.techlab.solid.helper.validacao.ValidacaoFuncionario;
import com.ciandt.techlab.solid.model.Vendedor;
import com.ciandt.techlab.solid.repository.VendedorRepository;
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
@RequestMapping("/vendedores")
public class VendedorController {

    private final VendedorRepository repository;

    private final ValidacaoFuncionario validacaoFuncionarioHelper;

    private final CalculaHelper calculaHelper;

    @PostMapping
    public ResponseEntity<Vendedor> salvar(@RequestBody Vendedor vendedor) {
        if("Nome preenchido incorretamente".equals(validacaoFuncionarioHelper.validarNome(vendedor.getNome()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(vendedor));
    }

    @GetMapping("/{id}/bonificacao")
    public Double obterSalarioBonificado(@PathVariable Long id) {
        Vendedor vendedor = repository.findById(id).orElseThrow();
        return calculaHelper.calculaSalarioComBonificacao(vendedor);
    }

    @GetMapping("/{id}/bonificacao-comissao")
    public Double obterSalarioBonificadoEComissionado(@PathVariable Long id) {
        Vendedor vendedor = repository.findById(id).orElseThrow();
        return calculaHelper.calculaSalarioComBonificacaoEComissao(vendedor);
    }
}
