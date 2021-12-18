package com.ciandt.techlab.solid.model;

import com.ciandt.techlab.solid.helper.RegraDeCalculo;
import com.ciandt.techlab.solid.helper.RegraDezPorcento;
import com.ciandt.techlab.solid.helper.RegraTrintaPorcento;
import com.ciandt.techlab.solid.helper.RegraVintePorcento;

public enum Cargo {

    DESENVOLVEDOR_JUNIOR(new RegraDezPorcento()),
    DESENVOLVEDOR_PLENO(new RegraVintePorcento()),
    DESENVOLVEDOR_SENIOR(new RegraTrintaPorcento());

    private RegraDeCalculo regra;

    Cargo(RegraDeCalculo regra){
        this.regra = regra;
    }

    public RegraDeCalculo getRegra() {
        return regra;
    }
}
