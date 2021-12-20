package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;

public class ValidacaoFuncionario implements IValidacaoFuncionario{

    @Override
    public String validarCpf(Funcionario funcionario) {
        return funcionario.getCpf().equals("") ? "Email preenchido incorretamente:" :  "Email preenchido corretamente";
    }

    @Override
    public String validarCurriculo(Funcionario funcionario) {
        return funcionario.getCurriculo().equals("") ? "Currículo preenchido incorretamente" : "Email preenchido corretamente";
    }

    @Override
    public String validarNome(Funcionario funcionario) {
        return funcionario.getNome().equals("") ? "Nome preenchido incorretamente" : "Nome preenchido corretamente";
    }


}
