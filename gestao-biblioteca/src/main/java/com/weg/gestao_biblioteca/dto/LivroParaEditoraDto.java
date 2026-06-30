package com.weg.gestao_biblioteca.dto;

import com.weg.gestao_biblioteca.model.enums.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record LivroParaEditoraDto (
        Long id,
        String titulo,
        String isbn,
        LocalDate dataPublicacao,
        Categoria categoria,
        List<AutorResponseDto> autores
){
}
