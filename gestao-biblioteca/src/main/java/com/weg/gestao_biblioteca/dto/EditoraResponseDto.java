package com.weg.gestao_biblioteca.dto;

import java.util.List;

public record EditoraResponseDto(
        String cnpj,
        String nome,
        List<LivroParaEditoraDto> livros
) {
}
