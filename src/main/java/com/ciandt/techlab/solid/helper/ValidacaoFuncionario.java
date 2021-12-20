package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;
import java.util.Date;

public class ValidacaoFuncionario implements Validacao{


    @Override
    public String validarCpf(Funcionario funcionario) {
        return funcionario.getCpf().equals("") ? "Email preenchido incorretamente:" :  "Email preenchido corretamente";
    }

    @Override
    public String validarCurriculo(Funcionario funcionario) {
        return funcionario.getCurriculo().equals("") ? "Currículo preenchido incorretamente" : "Email preenchido corretamente";
    }

    @Override
    public String validarNome(String nome) {

        return nome.equals("") ? "Nome preenchido incorretamente" : "Nome preenchido corretamente";
    }

    @Override
    public String validarDataCadastro(Date data) {
        return data == null ? "Data preenchida incorretamente": "Data preenchida corretamente";
    }
}
