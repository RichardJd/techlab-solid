package com.ciandt.techlab.solid.helper;

import java.util.Date;

public interface IValidacaoProduto {

    String validarNome(String nome);

    String validarDataCadastro(Date data);
}
