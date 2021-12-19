package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.helper.CalculaHelper;
import com.ciandt.techlab.solid.model.Vendedor;
import com.ciandt.techlab.solid.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
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

    private final CalculaHelper calculaHelper;
    private final VendedorRepository vendedorRepository;

    @PostMapping
    public Vendedor salvar(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @GetMapping("/{id}/bonificacao")
    public Double obterSalarioBonificado(@PathVariable Long id) {
        var vendedor = vendedorRepository.findById(id).orElseThrow();

        return calculaHelper.calculaSalarioComBonificacao(vendedor);
    }

    @GetMapping("/{id}/bonificacao/comissao")
    public Double obterSalarioBonificadoComComissao(@PathVariable Long id) {
        Vendedor vendedor = vendedorRepository.findById(id).orElseThrow();

        return calculaHelper.calculaSalarioComBonificacaoEComissao(vendedor);
    }
}
