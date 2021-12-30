package com.ciandt.techlab.solid.helper.validacao;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoProdutoHelper implements ValidacaoProduto {

    @Override
    public String validarDataCadastro(Date data) {
        return data == null ? "Data preenchida incorretamente": "Data preenchida corretamente";
    }
}
