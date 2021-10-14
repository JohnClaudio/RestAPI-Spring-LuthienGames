package com.br.generation.luthiengames.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;
import com.br.generation.luthiengames.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.br.generation.luthiengames.repository.UsuarioRepository;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() {

        Usuario usuario = new Usuario(0, "João da Silva", "joao@email.com.br", "13465278");
       if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            usuarioRepository.save(usuario);

        Usuario usuario_2 = new Usuario(0, "Andreia Flavia Silva", "silvia@email.com.br", "13465278");
       if(!usuarioRepository.findByUsuario(usuario_2.getUsuario()).isPresent())
            usuarioRepository.save(usuario_2);

        Usuario usuario_3 = new Usuario(0, "Eowyn Haikela Santos Silva", "haikela@email.com.br", "13465278");
        if(!usuarioRepository.findByUsuario(usuario_3.getUsuario()).isPresent())
            usuarioRepository.save(usuario_3);
}


    @Test
    @DisplayName("💾 Retorna o nome")
    public void findByNomeRetornaNome() throws Exception {
        Usuario usuario = usuarioRepository.findByNome("João da Silva");
        assertTrue(usuario.getNome().equals("João da Silva"));
    }


    @Test
    @DisplayName("💾 Retorna 3 usuarios")
    public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {

        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
        assertEquals(3, listaDeUsuarios.size());
    }



    @AfterAll
    public void end() {

        usuarioRepository.deleteAll();

    }
}