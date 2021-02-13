package com.waterkemper.springsecurityjwt.api;

import com.waterkemper.springsecurityjwt.api.dtos.PessoaDto;
import com.waterkemper.springsecurityjwt.model.Pessoa;
import com.waterkemper.springsecurityjwt.model.PessoaService;
import com.waterkemper.springsecurityjwt.repositories.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/v1/api/pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;
    private final PessoaService pessoaService;
    private final EntityManager entityManager;

    public PessoaController(PessoaRepository pessoaRepository,
                            PessoaService pessoaService,
                            EntityManager entityManager) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaService = pessoaService;
        this.entityManager = entityManager;
    }

    @PostMapping
//    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {

        Pessoa saved = pessoaService.save(pessoa);
//        Pessoa outra = pessoaService.save(pessoa);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll() {
        ResponseEntity<List<PessoaDto>> ok = ResponseEntity.ok(pessoaService.findPessoas());
        return ok;
    }
}
