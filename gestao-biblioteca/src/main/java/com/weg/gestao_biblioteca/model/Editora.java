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
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cnpj;
    private String nome;

    @OneToMany(mappedBy = "editora")
    private List<Livro> livros = new ArrayList<>();
}
