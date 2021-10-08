package com.br.generation.luthiengames.repository;

import com.br.generation.luthiengames.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public List<Usuario> findAllByUsuarioContainingIgnoreCase(String titulo);
    public Optional<Usuario> findByUsuario(String usuario);

}
