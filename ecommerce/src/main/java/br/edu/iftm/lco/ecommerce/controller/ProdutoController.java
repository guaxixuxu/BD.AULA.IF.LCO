package br.edu.iftm.lco.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.lco.ecommerce.dao.ProdutoDAO;
import br.edu.iftm.lco.ecommerce.domain.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoDAO.listaProdutos();
        return ResponseEntity.ok(produtos);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable Integer id) {
        Optional<Produto> produto = produtoDAO.buscaProdutoPorId(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        produtoDAO.insereProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoDAO.buscaProdutoPorId(id);
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome_produto(produtoAtualizado.getNome_produto());
            produto.setCategoria_id(produtoAtualizado.getCategoria_id());
            produto.setImagem(produtoAtualizado.getImagem());
            produto.setPrexo(produtoAtualizado.getPrexo());
            produto.setUn_produto(produtoAtualizado.getUn_produto());
            produtoDAO.atualizaProduto(produto);
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        if (produtoDAO.existeProdutoPorId(id)) {
            produtoDAO.deletaProdutoPorId(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
