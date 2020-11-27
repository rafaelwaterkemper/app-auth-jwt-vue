package com.waterkemper.springsecurityjwt.repositories;

import com.waterkemper.springsecurityjwt.model.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
}
