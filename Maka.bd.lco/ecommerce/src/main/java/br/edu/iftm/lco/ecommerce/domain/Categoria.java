package br.edu.iftm.lco.ecommerce.domain;

import lombok.Data;

@Data
public class Categoria {
    
    private Integer id;

    private String nome;

    private String descricao;

    public Categoria() {

    }

    public Categoria(Integer id, String nome, String descricao) {

        this.id = id;

        this.nome = nome;

        this.descricao = descricao;

    }
}
