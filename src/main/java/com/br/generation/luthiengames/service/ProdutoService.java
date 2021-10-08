package com.br.generation.luthiengames.service;

import com.br.generation.luthiengames.repository.ProdutoRepository;
import com.br.generation.luthiengames.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository service;

    public Produto createProduct (Produto produto)
    {
        return service.save(produto);
    }


    public List<Produto> getAll()
    {
        return service.findAll();
    }

    public Produto findById(long id)
    {
        Optional<Produto> categoria = service.findById(id);
        return categoria.get();
    }
    public List<Produto> findByNome(String nome)
    {
        return service.findAllByNomeContainingIgnoreCase(nome);
    }

    public void deleteById(long id)
    {
         service.deleteById(id);

    }

}
