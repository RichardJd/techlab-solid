package com.ciandt.techlab.solid.helper;

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
public class FuncionarioHelper {

    private final FuncionarioRepository repository;

    public Double calculaSalarioComBonificacao(Funcionario funcionario) {
        if (funcionario.getCargo().equals("DESENVOLVEDOR_JUNIOR")) {
            return funcionario.getSalario() + (funcionario.getSalario() * 0.1);
        } else if (funcionario.getCargo().equals("DESENVOLVEDOR_PLENO")) {
            return funcionario.getSalario() + (funcionario.getSalario() * 0.2);
        } else if ((funcionario.getCargo().equals("DESENVOLVEDOR_SENIOR"))) {
            return funcionario.getSalario() + (funcionario.getSalario() * 0.3);
        } else if ((funcionario.getCargo().equals("VENDEDOR_JUNIOR"))) {
            return funcionario.getSalario() + (funcionario.getSalario() * 0.1);
        } else if ((funcionario.getCargo().equals("VENDEDOR_PLENO"))) {
            return funcionario.getSalario() + (funcionario.getSalario() * 0.2);
        } else if ((funcionario.getCargo().equals("VENDEDOR_SENIOR"))) {
            return funcionario.getSalario() + (funcionario.getSalario() * 0.3);
        }
        return 0.0;
    }

    @PostMapping
    public Funcionario salvar(@RequestBody FuncionarioDtoRequest funcionarioDtoRequest) {
        return this.repository.save(Funcionario.valueOf(funcionarioDtoRequest));
    }

    @GetMapping("/{id}/bonificacao")
    public FuncionarioDtoResponse obterSalarioBonificado(@PathVariable Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow();
        Double salarioComBonificacao = this.calculaSalarioComBonificacao(funcionario);

        return FuncionarioDtoResponse.valueOf(funcionario, salarioComBonificacao);
    }
}
