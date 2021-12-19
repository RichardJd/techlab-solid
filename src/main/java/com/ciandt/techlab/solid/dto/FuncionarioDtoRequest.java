package com.ciandt.techlab.solid.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FuncionarioDtoRequest {

    private String nome;

    private String cargo;

    private Double salario;

}
