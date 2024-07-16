package com.example.challenge.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotNull
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne
    @NotNull
    private Usuario autor;

    @ManyToOne
    @NotNull
    private Curso curso;

    // Getters and Setters
}

