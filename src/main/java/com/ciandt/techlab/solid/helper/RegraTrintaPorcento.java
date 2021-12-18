package com.ciandt.techlab.solid.helper;

import com.ciandt.techlab.solid.model.Funcionario;

public class RegraTrintaPorcento implements RegraDeCalculo {

    @Override
    public Double calcula(Funcionario funcionario) {
        return funcionario.getSalario() + (funcionario.getSalario() * 0.3);
    }
}
