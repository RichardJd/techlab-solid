package com.ciandt.techlab.solid.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vendedor extends Funcionario {

    private Integer quantidadeDeItensVendidos;
}
