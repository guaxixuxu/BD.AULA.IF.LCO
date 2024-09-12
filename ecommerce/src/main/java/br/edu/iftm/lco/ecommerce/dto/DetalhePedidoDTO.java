package br.edu.iftm.lco.ecommerce.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DetalhePedidoDTO {
    private Integer id_pedido; //pk fk
    private String id_cliente; //fk
    private Date data_pedido;
    private Double desconto;
    private Double prexo_venda;
    private Integer id_produto; //fk
    private Integer qtd_produto;
}
