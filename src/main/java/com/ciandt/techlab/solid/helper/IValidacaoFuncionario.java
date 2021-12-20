package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;

public interface IValidacaoFuncionario {

    String validarCpf(Funcionario funcionario);

    String validarCurriculo(Funcionario funcionario);

    String validarNome(Funcionario funcionario);



}
