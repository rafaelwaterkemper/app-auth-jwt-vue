package com.waterkemper.repositories;

import com.waterkemper.model.Gerente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GerenteRepository extends PagingAndSortingRepository<Gerente, Gerente.PK> {
}
