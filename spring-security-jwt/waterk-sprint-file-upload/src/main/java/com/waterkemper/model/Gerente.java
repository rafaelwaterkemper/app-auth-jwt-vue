package com.waterkemper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Gerente {

    @EmbeddedId
    private PK id;

    @Column(name = "salario")
    private BigDecimal salario;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Embeddable
    public static final class PK implements Serializable {

        @Column(name = "i_gerente")
        private Long iGerente;

        @ManyToOne
        @JoinColumns(value = {
                @JoinColumn(name = "i_funcionarios"),
                @JoinColumn(name = "i_pessoas")
        },
                foreignKey = @ForeignKey(name = "FK_FUNC_GERENTE"))
        private Funcionario funcionario;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PK pk = (PK) o;
            return Objects.equals(iGerente, pk.iGerente) &&
                    Objects.equals(funcionario, pk.funcionario);
        }

        @Override
        public int hashCode() {
            return Objects.hash(iGerente, funcionario);
        }

        public Long getiGerente() {
            return iGerente;
        }

        public void setiGerente(Long iGerente) {
            this.iGerente = iGerente;
        }

        public Funcionario getFuncionario() {
            return funcionario;
        }

        public void setFuncionario(Funcionario funcionario) {
            this.funcionario = funcionario;
        }
    }
}
