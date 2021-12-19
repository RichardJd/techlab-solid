package com.ciandt.techlab.solid.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("DESENVOLVEDOR")
public class Desenvolvedor extends Funcionario {
}
