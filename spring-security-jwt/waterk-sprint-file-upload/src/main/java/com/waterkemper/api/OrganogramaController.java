package com.waterkemper.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waterkemper.model.ConfiguracaoOrganograma;
import com.waterkemper.model.Organograma;
import com.waterkemper.model.OrganogramaId;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/v1/api/")
@Transactional(propagation = Propagation.REQUIRED)
public class OrganogramaController {

    private final EntityManager entityManager;
    private final ObjectMapper mapper;

    public OrganogramaController(EntityManager entityManager, ObjectMapper mapper) {
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @PostMapping("config-organograma")
    public ConfiguracaoOrganograma saveConfig(@RequestBody ConfiguracaoOrganograma configuracaoOrganograma) {
        entityManager.persist(configuracaoOrganograma);
        return configuracaoOrganograma;
    }

    @PostMapping("organograma")
    public Organograma saveOrganograma(@RequestBody Organograma organograma) {
        entityManager.persist(organograma);
        return organograma;
    }

    @GetMapping("organograma")
    public Organograma find(@RequestBody String payload) throws JsonProcessingException {
        Organograma organograma = mapper.readValue(payload, Organograma.class);
        Organograma organograma1 = entityManager.find(Organograma.class, organograma.getId());
        return organograma1;
    }

    @PostMapping("test")
    public void test() {
        ConfiguracaoOrganograma configOrga = ConfiguracaoOrganograma.Builder.create().id(2L)
                .descricao("Teste")
                .build();

        OrganogramaId id = OrganogramaId.Builder.create()
                .iOrganogramas("1")
                .configuracaoOrganograma(configOrga)
                .build();

        Organograma organograma = Organograma.Builder.create()
                .id(id)
                .descricao("Organograma")
                .build();

        entityManager.persist(organograma);
        entityManager.flush();
    }
}
