package com.weg.gestao_biblioteca.dto;

import java.util.List;

public record EditoraResponseDto(
        Long id,
        String nome,
        String cnpj,
        List<LivroParaEditoraDto> livros
) {
}
