package com.ciandt.techlab.solid.helper.calculo;

import com.ciandt.techlab.solid.model.Desenvolvedor;
import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.model.Vendedor;
import org.springframework.stereotype.Component;

@Component
public class RegraDeCalculoJunior implements RegraDeCalculo {

    @Override
    public Double calculaSalarioComBonificacao(Funcionario funcionario) {
        return funcionario.getSalario() + (funcionario.getSalario() * 0.1);
    }

    @Override
    public Double calculaSalarioComBonificacaoEComissao(Vendedor vendedor) {
        return this.calculaSalarioComBonificacao(vendedor) + (vendedor.getQuantidadeDeItensVendidos() * 0.02);
    }

    @Override
    public Double calculaSalarioComBonificacaoEHorasExtras(Desenvolvedor desenvolvedor) {
        return this.calculaSalarioComBonificacao(desenvolvedor) + (desenvolvedor.getQuantidadeHorasExtras() * 0.1);
    }
}
