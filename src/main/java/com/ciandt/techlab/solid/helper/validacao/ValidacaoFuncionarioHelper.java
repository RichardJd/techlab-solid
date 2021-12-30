package com.ciandt.techlab.solid.helper.validacao;

import com.ciandt.techlab.solid.model.Funcionario;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoFuncionarioHelper implements ValidacaoFuncionario {

    @Override
    public String validarCpf(Funcionario funcionario) {
        return funcionario.getCpf().equals("") ? "Cpf preenchido incorretamente:" :  "Cpf preenchido corretamente";
    }

    @Override
    public String validarCurriculo(Funcionario funcionario) {
        return funcionario.getCurriculo().equals("") ? "Currículo preenchido incorretamente" : "Currículo preenchido corretamente";
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
