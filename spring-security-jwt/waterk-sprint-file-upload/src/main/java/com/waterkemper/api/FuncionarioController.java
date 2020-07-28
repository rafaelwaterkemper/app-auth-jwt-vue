package com.waterkemper.api;

import com.waterkemper.model.Funcionario;
import com.waterkemper.model.Pessoa;
import com.waterkemper.repositories.FuncionarioRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;

@RestController
@RequestMapping("/v1/api/funcionario")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;
    private final EntityManager entityManager;

    public FuncionarioController(FuncionarioRepository funcionarioRepository, EntityManager entityManager) {
        this.funcionarioRepository = funcionarioRepository;
        this.entityManager = entityManager;
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/coumpound-key")
    public Funcionario findByCompoundKey() throws NoSuchFieldException, IllegalAccessException {
        Funcionario.PK pk = new Funcionario.PK();
        Pessoa pessoa = new Pessoa();
        Field id = Pessoa.class.getDeclaredField("id");
        id.setAccessible(true);
        id.set(pessoa, 1L);
//        pessoa.setId(2L);
        pk.setPessoa(pessoa);

        Funcionario funcionario = entityManager.find(Funcionario.class, pk);
        return funcionario;
    }
}
