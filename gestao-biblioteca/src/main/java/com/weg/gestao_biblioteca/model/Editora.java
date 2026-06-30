package com.weg.gestao_biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    public Editora(@NotNull(message = "Não pode ser nulo") @NotEmpty(message = "Não pode ser vazio") @NotBlank(message = "Não pode ser branco") String nome,
                   @NotNull(message = "Não pode ser nulo") @NotEmpty(message = "Não pode ser vazio") @NotBlank(message = "Não pode ser branco") String cnpj) {

        this.nome = nome;
        this.cnpj = cnpj;
    }
}
