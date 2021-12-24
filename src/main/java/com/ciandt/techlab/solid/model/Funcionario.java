package com.ciandt.techlab.solid.model;

import com.ciandt.techlab.solid.dto.FuncionarioDtoRequest;
import java.util.Date;
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

    private String cpf;

    private String curriculo;

    private Date dataCadastro;

    private String cargo;

    private Double salario;

    private Integer quantidadeDeItensVendidos;

    private Integer quantidadeHorasExtras;


    public static Funcionario valueOf(FuncionarioDtoRequest funcionarioDtoRequest) {
        return Funcionario
            .builder()
            .nome(funcionarioDtoRequest.getNome())
            .cargo(funcionarioDtoRequest.getCargo())
            .salario(funcionarioDtoRequest.getSalario())
            .build();
    }

    public Double calculaSalarioComBonificacao() {
        if (this.getCargo().equals("DESENVOLVEDOR_JUNIOR")) {
            return this.getSalario() + (this.getSalario() * 0.1);
        } else if (this.getCargo().equals("DESENVOLVEDOR_PLENO")) {
            return this.getSalario() + (this.getSalario() * 0.2);
        } else if ((this.getCargo().equals("DESENVOLVEDOR_SENIOR"))) {
            return this.getSalario() + (this.getSalario() * 0.3);
        } else if ((this.getCargo().equals("VENDEDOR_JUNIOR"))) {
            return this.getSalario() + (this.getSalario() * 0.1);
        } else if ((this.getCargo().equals("VENDEDOR_PLENO"))) {
            return this.getSalario() + (this.getSalario() * 0.2);
        } else if ((this.getCargo().equals("VENDEDOR_SENIOR"))) {
            return this.getSalario() + (this.getSalario() * 0.3);
        }
        return 0.0;
    }

    public Double calculaSalarioComBonificacaoEComissao() {
        if ((this.getCargo().equals("VENDEDOR_JUNIOR"))) {
            return this.calculaSalarioComBonificacao() + (this.getQuantidadeDeItensVendidos() * 0.02);
        } else if ((this.getCargo().equals("VENDEDOR_PLENO"))) {
            return this.calculaSalarioComBonificacao() + (this.calculaSalarioComBonificacao() * 0.05);
        } else if ((this.getCargo().equals("VENDEDOR_SENIOR"))) {
            return this.calculaSalarioComBonificacao() + (this.calculaSalarioComBonificacao() * 0.1);
        }
        return 0.0;
    }

    public Double calculaSalarioComHorasExtras() {
        return calculaSalarioComBonificacao() + (this.getQuantidadeHorasExtras() * 0.05);
    }
}
