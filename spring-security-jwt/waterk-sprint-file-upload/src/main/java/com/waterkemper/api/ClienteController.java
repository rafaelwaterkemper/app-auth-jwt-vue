package com.waterkemper.api;

import com.waterkemper.model.Cliente;
import com.waterkemper.repositories.ClienteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll(Sort.sort(Cliente.class));
    }
}
