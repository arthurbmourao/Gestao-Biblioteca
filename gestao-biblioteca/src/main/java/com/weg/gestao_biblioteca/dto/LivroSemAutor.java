package com.weg.gestao_biblioteca.dto;

import com.weg.gestao_biblioteca.model.enums.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroSemAutor(
        Long id,
        String titulo,
        String isbn,
        BigDecimal preco,
        LocalDate dataPublicacao,
        Categoria categoria,
        EditoraSemLivros editora
) {
}
