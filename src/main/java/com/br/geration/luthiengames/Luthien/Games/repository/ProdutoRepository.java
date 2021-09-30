package com.br.geration.luthiengames.Luthien.Games.repository;

import com.br.geration.luthiengames.Luthien.Games.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
}
