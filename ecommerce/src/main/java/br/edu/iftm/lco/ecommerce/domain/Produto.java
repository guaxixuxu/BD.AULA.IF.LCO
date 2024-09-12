package br.edu.iftm.lco.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
public class Produto {
    private Integer id_produto;
    private Integer categoria_id;
    private String imagem;
    private Double prexo;
    private String nome_produto;
    private Integer un_produto;
}


