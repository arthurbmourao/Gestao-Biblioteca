package com.weg.gestao_biblioteca.model;

import com.weg.gestao_biblioteca.model.enums.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String isbn;
    private BigDecimal preco;
    private LocalDate dataPublicacao;
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;
    @ManyToMany
    @JoinTable(name = "livro_autores")
    private List<Autor> autores = new ArrayList<>();


    public Livro(@NotNull(message = "Não pode ser nulo") @NotEmpty(message = "Não pode ser vazio") @NotBlank(message = "Não pode ser branco") String titulo, @NotNull(message = "Não pode ser nulo") @NotEmpty(message = "Não pode ser vazio") @NotBlank(message = "Não pode ser branco") String isbn, @Min(1) BigDecimal preco, @Past LocalDate localDate) {
    }
}
