package com.example.challenge.controller;


import com.example.challenge.model.Topico;
import com.example.challenge.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> criar(@RequestBody @Valid Topico topico) {
        Topico topicoCriado = topicoService.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoCriado);
    }

    @GetMapping
    public List<Topico> listar() {
        return topicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalhar(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.findById(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        Optional<Topico> optional = topicoService.findById(id);
        if (optional.isPresent()) {
            Topico topicoAtualizado = topicoService.save(topico);
            return ResponseEntity.ok(topicoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<Topico> optional = topicoService.findById(id);
        if (optional.isPresent()) {
            topicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
