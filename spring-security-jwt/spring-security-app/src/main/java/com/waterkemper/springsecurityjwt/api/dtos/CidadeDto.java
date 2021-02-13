package com.waterkemper.springsecurityjwt.api.dtos;

import com.waterkemper.springsecurityjwt.model.Cidade;

public class CidadeDto {

    private Long id;

    private String nome;

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

    public static CidadeDto toDto(Cidade cidade) {
        CidadeDto cidadeDto = new CidadeDto();
        cidadeDto.setId(cidade.getId());
        cidadeDto.setNome(cidade.getNome());
        return cidadeDto;
    }
}
