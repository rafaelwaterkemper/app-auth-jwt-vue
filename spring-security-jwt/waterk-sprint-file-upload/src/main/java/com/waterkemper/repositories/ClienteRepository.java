package com.waterkemper.repositories;

import com.waterkemper.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
}
