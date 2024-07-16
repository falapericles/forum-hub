package com.example.challenge.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    // Getters and Setters
}


