package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.model.Vendedor;

public class RegraDeCalculoSenior implements RegraDeCalculo {

    @Override
    public Double calculaSalarioComBonificacao(Funcionario funcionario) {
        return funcionario.getSalario() + (funcionario.getSalario() * 0.3);
    }

    @Override
    public Double calculaSalarioComBonificacaoEComissao(Vendedor vendedor) {
        return calculaSalarioComBonificacao(vendedor) + (vendedor.getQuantidadeDeItensVendidos()) * 0.1;
    }
}
