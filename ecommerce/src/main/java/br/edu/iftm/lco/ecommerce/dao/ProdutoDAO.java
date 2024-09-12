package br.edu.iftm.lco.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.lco.ecommerce.domain.Produto;

@Repository
public class ProdutoDAO {
    
    @Autowired
    private JdbcTemplate jdbc;

    
    public int insereProduto(Produto produto) {
        String sql = "INSERT INTO db_ecommerce.produtos (CategoriaID, Imagem, preco, ProdutoNome, UnidadesEmEstoque) VALUES (?, ?, ?, ?, ?)";
        return jdbc.update(sql, 
            produto.getCategoria_id(), 
            produto.getImagem(), 
            produto.getPrexo(), 
            produto.getNome_produto(),
            produto.getUn_produto()
        );
    }

    
    public List<Produto> listaProdutos() {
        String sql = "SELECT * FROM db_ecommerce.produtos";
        return jdbc.query(sql, (res, rowNum) -> new Produto(
            res.getInt("ProdutoID"),
            res.getInt("CategoriaID"),
            res.getString("Imagem"),
            res.getDouble("preco"),
            res.getString("ProdutoNome"),
            res.getInt("UnidadesEmEstoque")
        ));
    }

    
    public Optional<Produto> buscaProdutoPorId(Integer id) {
        String sql = "SELECT * FROM db_ecommerce.produtos WHERE ProdutoID = ?";
        List<Produto> produtos = jdbc.query(sql, (res, rowNum) -> new Produto(
            res.getInt("ProdutoID"),
            res.getInt("CategoriaID"),
            res.getString("Imagem"),
            res.getDouble("preco"),
            res.getString("ProdutoNome"),
            res.getInt("UnidadesEmEstoque")
        ), id);

        if (produtos.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(produtos.get(0));
        }
    }

    
    public int atualizaProduto(Produto produto) {
        String sql = "UPDATE db_ecommerce.produtos SET CategoriaID = ?, Imagem = ?, preco = ?, ProdutoNome = ?, UnidadesEmEstoque = ? WHERE ProdutoID = ?";
        return jdbc.update(sql,
            produto.getCategoria_id(),
            produto.getImagem(),
            produto.getPrexo(),
            produto.getNome_produto(),
            produto.getUn_produto(),
            produto.getId_produto()
        );
    }

    
    public int deletaProdutoPorId(Integer id) {
        String sql = "DELETE FROM db_ecommerce.produtos WHERE ProdutoID = ?";
        return jdbc.update(sql, id);
    }

    
    public boolean existeProdutoPorId(Integer id) {
        String sql = "SELECT COUNT(*) FROM db_ecommerce.produtos WHERE ProdutoID = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
