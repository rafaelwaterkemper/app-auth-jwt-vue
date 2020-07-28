package com.waterkemper.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrganogramaId implements Serializable {

    @ManyToOne
    @NotNull
    @JoinColumn(name = "i_config_organ", referencedColumnName = "i_config_organ")
//    @Column(name = "i_config_organ")
    private ConfiguracaoOrganograma configuracaoOrganograma;

    @NotNull
    @Size(max = 16)
    @Column(name = "i_organogramas")
    private String iOrganogramas;

    public ConfiguracaoOrganograma getConfiguracaoOrganograma() {
        return configuracaoOrganograma;
    }

    public String getiOrganogramas() {
        return iOrganogramas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganogramaId that = (OrganogramaId) o;
        return Objects.equals(configuracaoOrganograma, that.configuracaoOrganograma) &&
                Objects.equals(iOrganogramas, that.iOrganogramas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configuracaoOrganograma, iOrganogramas);
    }

    public static final class Builder extends EntityBuilder<OrganogramaId> {
        private Builder(OrganogramaId entity, EntityState state) {
            super(entity, state);
        }

        public static Builder create() {
            return new Builder(new OrganogramaId(), EntityState.NEW);
        }

        public static Builder from(OrganogramaId entity) {
            return new Builder(entity, EntityState.BUILT);
        }

        public Builder configuracaoOrganograma(ConfiguracaoOrganograma configuracaoOrganograma) {
            entity.configuracaoOrganograma = configuracaoOrganograma;
            return this;
        }

        public Builder iOrganogramas(String iOrganogramas) {
            entity.iOrganogramas = iOrganogramas;
            return this;
        }
    }
}
