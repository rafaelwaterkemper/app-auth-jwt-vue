package com.waterkemper.springsecurityjwt.api.dtos;

import com.waterkemper.springsecurityjwt.model.Pessoa;

public class PessoaDto {

    private Long id;

    private String nome;

    private CidadeDto cidadeDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CidadeDto getCidadeDto() {
        return cidadeDto;
    }

    public void setCidadeDto(CidadeDto cidadeDto) {
        this.cidadeDto = cidadeDto;
    }

    public static PessoaDto toDto(Pessoa pessoa) {
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(pessoa.getId());
        pessoaDto.setNome(pessoa.getNome());
        if (pessoa.getCidade() != null) {
            pessoaDto.setCidadeDto(CidadeDto.toDto(pessoa.getCidade()));
        }
        return pessoaDto;
    }
}
