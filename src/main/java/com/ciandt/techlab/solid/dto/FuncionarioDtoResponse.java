package com.ciandt.techlab.solid.dto;

import com.ciandt.techlab.solid.model.Funcionario;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FuncionarioDtoResponse {

    private Long codigo;

    private String nome;

    private String cargo;

    private Double salario;

    private Double salarioBonificado;

    public static FuncionarioDtoResponse valueOf(Funcionario funcionario, Double salarioBonificado) {
        return FuncionarioDtoResponse
            .builder()
            .codigo(funcionario.getCodigo())
            .nome(funcionario.getNome())
            .cargo(funcionario.getCargo())
            .salario(funcionario.getSalario())
            .salarioBonificado(salarioBonificado)
            .build();
    }
}
