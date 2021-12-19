package com.ciandt.techlab.solid.model;

import com.ciandt.techlab.solid.helper.RegraDeCalculo;
import com.ciandt.techlab.solid.helper.RegraDeCalculoJunior;
import com.ciandt.techlab.solid.helper.RegraDeCalculoSenior;
import com.ciandt.techlab.solid.helper.RegraDeCalculoPleno;

public enum NivelCargo {

    JUNIOR(new RegraDeCalculoJunior()),
    PLENO(new RegraDeCalculoPleno()),
    SENIOR(new RegraDeCalculoSenior());

    private RegraDeCalculo regra;

    NivelCargo(RegraDeCalculo regra){
        this.regra = regra;
    }

    public RegraDeCalculo getRegra() {
        return regra;
    }
}
