package com.example.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Getter
    @NotBlank
    @Email
    private String email;

    @Getter
    @NotBlank
    @Size(min = 6)
    private String senha;

    public @NotBlank @Size(min = 6) String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank @Size(min = 6) String senha) {
        this.senha = senha;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

}
