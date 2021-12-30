package com.ciandt.techlab.solid.helper.calculo;

import com.ciandt.techlab.solid.model.Desenvolvedor;
import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.model.Vendedor;
import org.springframework.stereotype.Component;

@Component
public class CalculaHelper {

    public Double calculaSalarioComBonificacao(Funcionario funcionario) {
        return funcionario.getNivelCargo().getRegraDeCalculo().calculaSalarioComBonificacao(funcionario);
    }

    public Double calculaSalarioComBonificacaoEComissao(Vendedor vendedor) {
        return vendedor.getNivelCargo().getRegraDeCalculo().calculaSalarioComBonificacaoEComissao(vendedor);
    }

    public Double calculaSalarioComBonificacaoEHorasExtras(Desenvolvedor desenvolvedor) {
        return desenvolvedor.getNivelCargo().getRegraDeCalculo().calculaSalarioComBonificacaoEHorasExtras(desenvolvedor);
    }
}
