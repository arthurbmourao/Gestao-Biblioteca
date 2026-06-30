package com.weg.gestao_biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;
    @ManyToMany
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome, String nacionalidade, List<Livro> livros) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.livros = livros;
    }
}

