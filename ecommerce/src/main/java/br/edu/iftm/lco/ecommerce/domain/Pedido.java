package br.edu.iftm.lco.ecommerce.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Pedido {
    private String id_cliente;
    private Date data_pedido;
    private Integer id_pedido;
}
