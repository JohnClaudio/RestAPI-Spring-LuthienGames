package com.br.generation.luthiengames.controller;

import com.br.generation.luthiengames.model.Categoria;
import com.br.generation.luthiengames.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class ControllerCategoria {

    @Autowired
    private CategoriaService categoria;


    @GetMapping()
    public ResponseEntity<List<Categoria>> getAll()
    {
        return ResponseEntity.ok().body(categoria.getAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable long id)
    {
        return ResponseEntity.ok().body(categoria.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Categoria>> getByName(@PathVariable String nome)
    {
        return ResponseEntity.ok().body(categoria.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Categoria> createProduct(@RequestBody Categoria obj )
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria.createCategoria(obj));
    }

    @PutMapping
    public ResponseEntity<Categoria> updateProduct(@RequestBody Categoria obj )
    {
        return ResponseEntity.status(HttpStatus.OK).body(categoria.createCategoria(obj));
    }

    @DeleteMapping
    public void deletebyId(Long id)
    {
        categoria.deleteById(id);
    }
}
