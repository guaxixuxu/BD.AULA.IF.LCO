package br.edu.iftm.lco.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Categoria {
    private Integer id_categoria;
    private String categoria;
    private String descrixao;

}
