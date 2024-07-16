package com.example.challenge.controller;

import com.example.challenge.model.Usuario;
import com.example.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
    @RequestMapping("/api/usuarios")
    public class UsuarioController {

        private final UserService usuarioService;

        @Autowired
        public UsuarioController(UserService usuarioService) {
            this.usuarioService = usuarioService;
        }

        @PostMapping("/cadastro")
        public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
            Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        }

        @GetMapping("/{email}")
        public ResponseEntity<Optional<Usuario>> buscarUsuarioPorEmail(@PathVariable String email) {
            Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

