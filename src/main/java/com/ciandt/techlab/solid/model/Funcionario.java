package com.ciandt.techlab.solid.model;

import com.ciandt.techlab.solid.dto.FuncionarioDtoRequest;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private String cargo;

    private Double salario;

    public static Funcionario valueOf(FuncionarioDtoRequest funcionarioDtoRequest) {
        return Funcionario
            .builder()
            .nome(funcionarioDtoRequest.getNome())
            .cargo(funcionarioDtoRequest.getCargo())
            .salario(funcionarioDtoRequest.getSalario())
            .build();
    }
}
