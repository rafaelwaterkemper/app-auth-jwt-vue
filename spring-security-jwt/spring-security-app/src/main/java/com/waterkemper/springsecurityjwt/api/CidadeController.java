package com.waterkemper.springsecurityjwt.api;

import com.waterkemper.springsecurityjwt.api.dtos.CidadeDto;
import com.waterkemper.springsecurityjwt.model.Cidade;
import com.waterkemper.springsecurityjwt.repositories.CidadeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/api/cidade")
public class CidadeController {

    private CidadeRepository cidadeRepository;

    public CidadeController(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @PostMapping
    @Transactional
    public void post(@RequestBody Cidade cidade) {
        cidadeRepository.save(cidade);
    }

    @GetMapping
    public ResponseEntity<List<CidadeDto>> findAll() {
        return ResponseEntity.ok(
                StreamSupport.stream(cidadeRepository.findAll().spliterator(), false)
                        .map(CidadeDto::toDto)
                        .collect(Collectors.toList())
        );
    }

}
