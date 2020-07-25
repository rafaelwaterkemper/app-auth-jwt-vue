package com.waterkemper.repositories;

import com.waterkemper.model.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
}
