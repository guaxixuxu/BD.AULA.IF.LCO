package br.edu.iftm.lco.ecommerce.domain;

import lombok.Data;

@Data
public class Cliente {
    private String id_client;
    private String cargo;
    private String cep;
    private String cidade;
    private String enderexo;
    private String fax;
    private String nome;
    private String pais;
    private String telefone;

}
