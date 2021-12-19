package com.ciandt.techlab.solid.model;

import com.ciandt.techlab.solid.dto.FuncionarioDtoRequest;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private String cargo;

    private Double salario;

    public static Funcionario valueOf(FuncionarioDtoRequest funcionarioDtoRequest) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDtoRequest.getNome());
        funcionario.setCargo(funcionarioDtoRequest.getCargo());
        funcionario.setSalario(funcionarioDtoRequest.getSalario());
        return funcionario;
    }
}
