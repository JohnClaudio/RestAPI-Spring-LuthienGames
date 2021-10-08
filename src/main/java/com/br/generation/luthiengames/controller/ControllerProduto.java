package com.br.generation.luthiengames.controller;

import com.br.generation.luthiengames.model.Produto;
import com.br.generation.luthiengames.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produto")
public class ControllerProduto {

    @Autowired
    private ProdutoService produto;


    @GetMapping()
    public ResponseEntity <List<Produto>> getAll()
    {
        return ResponseEntity.ok().body(produto.getAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id)
    {
        return ResponseEntity.ok().body(produto.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByName(@PathVariable String nome)
    {
        return ResponseEntity.ok().body(produto.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Produto> createProduct(@RequestBody Produto obj )
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(produto.createProduct(obj));
    }
    @PutMapping
    public ResponseEntity<Produto> updateProduct(@RequestBody Produto obj )
    {
        return ResponseEntity.status(HttpStatus.OK).body(produto.createProduct(obj));
    }

    @DeleteMapping
    public void deletebyId(Long id)
    {
        produto.deleteById(id);
    }

}
