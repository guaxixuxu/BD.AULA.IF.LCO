package br.edu.iftm.lco.ecommerce.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import br.edu.iftm.lco.ecommerce.domain.Categoria;

@Component
public class CategoriaDao {

    @Autowired

    private JdbcTemplate db;

    public List<Categoria> getCategorias() {

        String sql = "select categoriaID, categoria, descricao from categorias";

        return db.query(sql, (res, rowNum) -> {

            return new Categoria(

                    res.getInt("categoriaID"),

                    res.getString("categoria"),

                    res.getString("descricao"));

        });
    }

}
