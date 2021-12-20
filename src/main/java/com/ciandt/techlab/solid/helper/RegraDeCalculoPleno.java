package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Desenvolvedor;
import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.model.Vendedor;

public class RegraDeCalculoPleno implements RegraDeCalculo {

    @Override
    public Double calculaSalarioComBonificacao(Funcionario funcionario) {
        return funcionario.getSalario() + (funcionario.getSalario() * 0.2);
    }

    @Override
    public Double calculaSalarioComBonificacaoEComissao(Vendedor vendedor) {
        return calculaSalarioComBonificacao(vendedor) + (vendedor.getQuantidadeDeItensVendidos()) * 0.05;
    }

    @Override
    public Double calculaSalarioComHorasExtras(Desenvolvedor desenvolvedor) {
        return calculaSalarioComBonificacao(desenvolvedor) +
                (desenvolvedor.getQuantidadeHorasExtras() * 0.05);
    }
}
