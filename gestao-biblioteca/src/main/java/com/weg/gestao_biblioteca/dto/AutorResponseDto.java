package com.weg.gestao_biblioteca.dto;

import java.util.List;

public record AutorResponseDto(
        Long id,
        String nome,
        String nacionalidade,
        List<LivroResponseDto> livros
) {
}
