package com.waterkemper.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waterkemper.model.Gerente;
import com.waterkemper.repositories.GerenteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/v1/api/gerente")
public class GerenteController {

    private final GerenteRepository gerenteRepository;
    private final EntityManager entityManager;
    private final ObjectMapper mapper;

    public GerenteController(GerenteRepository gerenteRepository, EntityManager entityManager, ObjectMapper mapper) {
        this.gerenteRepository = gerenteRepository;
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    @PostMapping
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Gerente save(@RequestBody Gerente gerente) {
        entityManager.persist(gerente);
        entityManager.flush();
        return gerente;
    }

    @PostMapping("/mapper")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Gerente saveMapper(@RequestBody String gerente) throws JsonProcessingException {
        Gerente gerente1 = mapper.readValue(gerente, Gerente.class);
        entityManager.persist(gerente1);
        return gerente1;
    }

    @GetMapping
    public List<Gerente> findAll(Gerente gerente) {
        return (List<Gerente>) gerenteRepository.findAll(Sort.sort(Gerente.class));
    }
}
