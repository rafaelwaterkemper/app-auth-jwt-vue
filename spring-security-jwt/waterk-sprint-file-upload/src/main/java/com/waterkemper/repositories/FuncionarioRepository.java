package com.waterkemper.repositories;

import com.waterkemper.model.Funcionario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Funcionario.PK> {
}
