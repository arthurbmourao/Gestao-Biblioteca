package com.weg.gestao_biblioteca.dto;

import com.weg.gestao_biblioteca.model.Autor;
import com.weg.gestao_biblioteca.model.Editora;
import com.weg.gestao_biblioteca.model.enums.Categoria;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record LivroResponseDto (
        Long id,
        String titulo,
        String isbn,
        BigDecimal preco,
        LocalDate dataPublicacao,
        Categoria categoria,
        EditoraSemLivros editora,
        List<AutorResponseDto> autores
) {
}
