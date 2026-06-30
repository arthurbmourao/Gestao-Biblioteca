package com.weg.gestao_biblioteca.mapper;

import com.weg.gestao_biblioteca.dto.AutorRequestDto;
import com.weg.gestao_biblioteca.dto.AutorResponseDto;
import com.weg.gestao_biblioteca.dto.AutorSemLivroDto;
import com.weg.gestao_biblioteca.model.Autor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AutorMapper {

    private final LivroMapper livroMapper;

    public Autor toEntity (AutorRequestDto autorRequestDto){
        return new Autor(
                autorRequestDto.nome(),
                autorRequestDto.nacionalidade(),
                null
        );
    }
    public AutorResponseDto toResponseDto(Autor autor){
        return new AutorResponseDto(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade(),
                autor.getLivros().stream().map(
                        livroMapper :: toSemAutor
                ).toList()
        );
    }

    public AutorSemLivroDto toAutorSemLivro(Autor autor){
        return new AutorSemLivroDto(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade()
        );
    }
}
