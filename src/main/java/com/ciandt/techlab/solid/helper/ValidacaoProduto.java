package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;
import java.util.Date;

public class ValidacaoProduto implements IValidacaoProduto{


    @Override
    public String validarNome(String nome) {

        return nome.equals("") ? "Nome preenchido incorretamente" : "Nome preenchido corretamente";
    }


    @Override
    public String validarDataCadastro(Date data) {
        return data == null ? "Data preenchida incorretamente": "Data preenchida corretamente";
    }
}
