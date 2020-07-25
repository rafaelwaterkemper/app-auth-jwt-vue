package com.waterkemper.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Funcionario {

    @EmbeddedId
    private PK id;

    @Column(name = "codigo")
    private String codigo;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Embeddable
    public static final class PK implements Serializable {

        @Column(name = "i_funcionarios")
        private Long iFuncionarios;

        @ManyToOne
        @JoinColumn(name = "i_pessoas")
        private Pessoa pessoa;

        public Long getiFuncionarios() {
            return iFuncionarios;
        }

        public void setiFuncionarios(Long iFuncionarios) {
            this.iFuncionarios = iFuncionarios;
        }

        public Pessoa getPessoa() {
            return pessoa;
        }

        public void setPessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PK pk = (PK) o;
            return Objects.equals(iFuncionarios, pk.iFuncionarios) &&
                    Objects.equals(pessoa, pk.pessoa);
        }

        @Override
        public int hashCode() {
            return Objects.hash(iFuncionarios, pessoa);
        }
    }
}
