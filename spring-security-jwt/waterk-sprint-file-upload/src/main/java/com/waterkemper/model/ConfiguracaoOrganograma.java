package com.waterkemper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vw_config_organ")
public class ConfiguracaoOrganograma {

    @Id
    @Column(name = "i_config_organ")
    private Long id;

    @Size(max = 40)
    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @Version
    @Column(name = "AUD_VERSAO")
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static final class Builder extends EntityBuilder<ConfiguracaoOrganograma> {

        private Builder(ConfiguracaoOrganograma entity, EntityState state) {
            super(entity, state);
        }

        public static Builder create() {
            return new Builder(new ConfiguracaoOrganograma(), EntityState.NEW);
        }

        public static Builder from(ConfiguracaoOrganograma entity) {
            return new Builder(entity, EntityState.BUILT);
        }

        public Builder id(Long id) {
            entity.id = id;
            return this;
        }

        public Builder descricao(String descricao) {
            entity.descricao = descricao;
            return this;
        }
    }
}
