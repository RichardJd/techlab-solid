package com.ciandt.techlab.solid.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("DESENVOLVEDOR")
@Data
public class Desenvolvedor extends Funcionario {

    private Integer quantidadeHorasExtras;
}
