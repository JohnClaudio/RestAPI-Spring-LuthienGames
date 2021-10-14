package com.br.generation.luthiengames.controller;

import com.br.generation.luthiengames.model.Categoria;
import com.br.generation.luthiengames.model.Usuario;
import com.br.generation.luthiengames.model.UsuarioLogin;
import com.br.generation.luthiengames.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }
    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> updateProduct(@RequestBody Usuario obj )
    {
        return usuarioService.cadastrarUsuario(obj)
                .map(respostaCadastro -> ResponseEntity.status(HttpStatus.OK).body(respostaCadastro))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioLogin> login_user(@RequestBody Optional<UsuarioLogin> user) {
        return usuarioService.autenticarUsuario(user)
                .map(respostaAutenticacao -> ResponseEntity.ok(respostaAutenticacao))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar_user(@RequestBody Usuario usuario) {

        return usuarioService.cadastrarUsuario(usuario)
                .map(respostaCadastro -> ResponseEntity.status(HttpStatus.CREATED).body(respostaCadastro))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

}
