package com.waterkemper.api;

import com.waterkemper.model.Pessoa;
import com.waterkemper.repositories.PessoaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        Pessoa saved = pessoaRepository.save(pessoa);
        return saved;
    }
}
