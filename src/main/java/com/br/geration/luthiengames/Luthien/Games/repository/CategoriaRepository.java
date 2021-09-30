package com.br.geration.luthiengames.Luthien.Games.repository;

import com.br.geration.luthiengames.Luthien.Games.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
}
