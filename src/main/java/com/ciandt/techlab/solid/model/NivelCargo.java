package com.ciandt.techlab.solid.model;

import com.ciandt.techlab.solid.helper.calculo.RegraDeCalculo;
import com.ciandt.techlab.solid.helper.calculo.RegraDeCalculoJunior;
import com.ciandt.techlab.solid.helper.calculo.RegraDeCalculoPleno;
import com.ciandt.techlab.solid.helper.calculo.RegraDeCalculoSenior;

public enum NivelCargo {

    JUNIOR(new RegraDeCalculoJunior()),
    PLENO(new RegraDeCalculoPleno()),
    SENIOR(new RegraDeCalculoSenior());

    private RegraDeCalculo regraDeCalculo;

    NivelCargo(RegraDeCalculo regraDeCalculo) {
        this.regraDeCalculo = regraDeCalculo;
    }

    public RegraDeCalculo getRegraDeCalculo() {
        return regraDeCalculo;
    }
}
