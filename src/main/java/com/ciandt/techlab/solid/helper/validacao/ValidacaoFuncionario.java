package com.ciandt.techlab.solid.helper.validacao;

import com.ciandt.techlab.solid.model.Funcionario;
import java.util.Date;

public interface ValidacaoFuncionario {

    String validarCpf(Funcionario funcionario);

    String validarCurriculo(Funcionario funcionario);

    String validarNome(String nome);

    String validarDataCadastro(Date data);
}
