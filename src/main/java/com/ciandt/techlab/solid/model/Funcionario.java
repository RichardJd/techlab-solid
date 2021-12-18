package com.ciandt.techlab.solid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private Cargo cargo;

    private Double salario;

    public Double calculaSalarioComBonificacao() {
        return this.cargo.getRegra().calcula(this);
    }
}
