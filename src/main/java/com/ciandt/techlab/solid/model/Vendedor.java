package com.ciandt.techlab.solid.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("VENDEDOR")
@Data
public class Vendedor extends Funcionario {

    private Integer quantidadeDeItensVendidos;
}
