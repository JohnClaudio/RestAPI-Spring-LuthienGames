package com.br.geration.luthiengames.Luthien.Games.service;

import com.br.geration.luthiengames.Luthien.Games.model.Categoria;
import com.br.geration.luthiengames.Luthien.Games.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository service;

    public Categoria createCategoria(Categoria categoria)
    {
        return service.save(categoria);
    }
    public List<Categoria> getAll()
    {
        return service.findAll();
    }

    public Categoria findById(long id)
    {
        Optional<Categoria> categoria = service.findById(id);
        return categoria.get();
    }

    public List<Categoria> findByNome(String nome)
    {
        return service.findAllByNomeContainingIgnoreCase(nome);
    }

    public Categoria deleteById(long id)
    {
        Optional<Categoria> categoria = service.findById(id);
        return categoria.get();
    }

}
