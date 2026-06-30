package com.weg.gestao_biblioteca.mapper;

import com.weg.gestao_biblioteca.dto.EditoraRequestDto;
import com.weg.gestao_biblioteca.dto.EditoraResponseDto;
import com.weg.gestao_biblioteca.dto.EditoraSemLivros;
import com.weg.gestao_biblioteca.model.Editora;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditoraMapper {

    private final LivroMapper livroMapper;

    public Editora toEntity (EditoraRequestDto editoraRequestDto){
        return new Editora(
                editoraRequestDto.nome(),
                editoraRequestDto.cnpj()
        );
    }

    public EditoraResponseDto toResponse(Editora editora){
        return new EditoraResponseDto(
                editora.getId(),
                editora.getNome(),
                editora.getCnpj(),
                editora.getLivros().stream().map(
                        livroMapper :: toLivroEditora
                ).toList()
        );
    }

    public EditoraSemLivros toEditoraSemLivro(Editora editora){
        return new EditoraSemLivros(
                editora.getNome(),
                editora.getCnpj()
        );
    }
}
