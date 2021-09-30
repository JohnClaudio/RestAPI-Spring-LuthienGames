package com.br.geration.luthiengames.Luthien.Games.controller;

import com.br.geration.luthiengames.Luthien.Games.model.Produto;
import com.br.geration.luthiengames.Luthien.Games.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/produto")
public class ControllerProduto {
    private ProdutoService produto;

    @GetMapping
    public List<Produto> todosProdutos(){

        return produto.getAll();

}

}
