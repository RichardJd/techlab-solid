package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;
import com.ciandt.techlab.solid.model.Vendedor;

public interface RegraDeCalculo {
    Double calculaSalarioComBonificacao(Funcionario funcionario);

    Double calculaSalarioComBonificacaoEComissao(Vendedor vendedor);
}
