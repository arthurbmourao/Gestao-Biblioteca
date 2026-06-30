package com.weg.gestao_biblioteca.mapper;

import com.weg.gestao_biblioteca.dto.AutorRequestDto;
import com.weg.gestao_biblioteca.dto.AutorSemLivroDto;
import com.weg.gestao_biblioteca.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {
    public Autor toEntity (AutorRequestDto autorRequestDto){
        return new Autor(
                autorRequestDto.nome(),
                autorRequestDto.nacionalidade(),
                null
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
