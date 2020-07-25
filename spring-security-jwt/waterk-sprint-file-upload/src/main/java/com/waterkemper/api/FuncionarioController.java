package com.waterkemper.api;

import com.waterkemper.model.Funcionario;
import com.waterkemper.repositories.FuncionarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/funcionario")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
}
