package com.waterkemper.api;

import com.waterkemper.model.Gerente;
import com.waterkemper.repositories.GerenteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/gerente")
public class GerenteController {

    private final GerenteRepository gerenteRepository;

    public GerenteController(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    @PostMapping
    public Gerente save(@RequestBody Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @GetMapping
    public List<Gerente> findAll(Gerente gerente) {
        return (List<Gerente>) gerenteRepository.findAll(Sort.sort(Gerente.class));
    }
}
