package com.waterkemper.springsecurityjwt.repositories;

import com.waterkemper.springsecurityjwt.model.Cidade;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CidadeRepository extends PagingAndSortingRepository<Cidade, Long> {
}
