package com.waterkemper.api;

import com.waterkemper.model.Cliente;
import com.waterkemper.repositories.ClienteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final EntityManager entityManager;

    public ClienteController(ClienteRepository clienteRepository, EntityManager entityManager) {
        this.clienteRepository = clienteRepository;
        this.entityManager = entityManager;
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        System.out.println("name");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> from = query.from(Cliente.class);
        CriteriaQuery<Cliente> select = query.select(from);
        entityManager.createQuery(select).getResultList();

        return clienteRepository.save(cliente);
    }

    @GetMapping
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll(Sort.sort(Cliente.class));
    }
}
