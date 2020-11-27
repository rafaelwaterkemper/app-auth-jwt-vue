package com.waterkemper.springsecurityjwt.model;

import com.waterkemper.springsecurityjwt.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    @Transactional(isolation = Isolation.DEFAULT)
    public List<Pessoa> findPessoas() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Pessoa save(Pessoa pessoa) {
        Pessoa save = repository.save(pessoa);
        System.out.println("Teste transaction");
        return save;

    }
}
