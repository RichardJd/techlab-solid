package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.model.Vendedor;
import org.springframework.stereotype.Component;

@Component
public class CalculaHelper {

    public Double calculaSalarioComBonificacao(Funcionario funcionario) {
        return funcionario.getNivelCargo().getRegra().calculaSalarioComBonificacao(funcionario);
    }

    public Double calculaSalarioComBonificacaoEComissao(Vendedor vendedor) {
        return vendedor.getNivelCargo().getRegra().calculaSalarioComBonificacaoEComissao(vendedor);
    }
}
