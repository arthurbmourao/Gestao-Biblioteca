package com.weg.gestao_biblioteca.mapper;

import com.weg.gestao_biblioteca.dto.LivroParaEditoraDto;
import com.weg.gestao_biblioteca.model.Autor;
import com.weg.gestao_biblioteca.model.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LivroMapper {

    private final AutorMapper autorMapper;

    //public LivroMapper(@Lazy AutorMapper autorMapper) {
    //    this.autorMapper = autorMapper;
    //}

    public LivroParaEditoraDto toLivroEditora(Livro livro){

        return new LivroParaEditoraDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getDataPublicacao(),
                livro.getCategoria(),
                livro.getAutores().stream().map(
                        autorMapper :: toAutorSemLivro
                ).toList()
        );
    }
}
