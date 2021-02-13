package com.waterkemper.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vw_organogramas")
public class Organograma {

    @NotNull
    @EmbeddedId
    private OrganogramaId id;

//    validator

    @Size(max = 50)
    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @Digits(integer = 22, fraction = 0)
    @NotNull
    @Column(name = "nivel")
    private Integer nivel;

    @Size(max = 1)
    @NotNull
    @Column(name = "tipo")
    private String tipo;

    @Null
    @Version
    @Column(name = "AUD_VERSAO")
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public OrganogramaId getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(OrganogramaId id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static final class Builder extends EntityBuilder<Organograma> {
        private Builder(Organograma entity, EntityState state) {
            super(entity, state);
        }

        public static Builder create() {
            return new Builder(new Organograma(), EntityState.NEW);
        }

        public static Builder from(Organograma entity) {
            return new Builder(entity, EntityState.BUILT);
        }

        public Builder id(OrganogramaId id) {
            entity.id = id;
            return this;
        }

        public Builder descricao(String descricao) {
            entity.descricao = descricao;
            return this;
        }

        public Builder nivel(Integer nivel) {
            entity.nivel = nivel;
            return this;
        }

        public Builder tipo(String tipo) {
            entity.tipo = tipo;
            return this;
        }
    }
}
