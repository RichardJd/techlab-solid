package com.ciandt.techlab.solid.controller;

import com.ciandt.techlab.solid.helper.CalculaHelper;
import com.ciandt.techlab.solid.model.Desenvolvedor;
import com.ciandt.techlab.solid.repository.DesenvolvedorRepository;
import lombok.RequiredArgsConstructor;
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

    private final CalculaHelper calculaHelper;
    private final DesenvolvedorRepository desenvolvedorRepository;

    @PostMapping
    public Desenvolvedor salvar(@RequestBody Desenvolvedor desenvolvedor) {
        return desenvolvedorRepository.save(desenvolvedor);
    }

    @GetMapping("/{id}/bonificacao")
    public Double obterSalarioBonificado(@PathVariable Long id) {
        var desenvolvedor = desenvolvedorRepository.findById(id).orElseThrow();

        return calculaHelper.calculaSalarioComBonificacao(desenvolvedor);
    }
}
