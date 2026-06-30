package com.weg.gestao_biblioteca.mapper;

import com.weg.gestao_biblioteca.dto.LivroParaEditoraDto;
import com.weg.gestao_biblioteca.dto.LivroResponseDto;
import com.weg.gestao_biblioteca.dto.LivroSemAutor;
import com.weg.gestao_biblioteca.model.Autor;
import com.weg.gestao_biblioteca.model.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class LivroMapper {

    private final AutorMapper autorMapper;
    private final EditoraMapper editoraMapper;

    public LivroMapper(@Lazy AutorMapper autorMapper, @Lazy EditoraMapper editoraMapper) {
        this.autorMapper = autorMapper;
        this.editoraMapper = editoraMapper;
    }


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

    public LivroResponseDto toResponse(Livro livro){
        return new LivroResponseDto(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getPreco(),
                livro.getDataPublicacao(),
                livro.getCategoria(),
                editoraMapper.toEditoraSemLivro(livro.getEditora()),
                livro.getAutores().stream().map(
                        autorMapper :: toAutorSemLivro
                ).toList()
        );
    }

    public LivroSemAutor toSemAutor(Livro livro){
        return new LivroSemAutor(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getPreco(),
                livro.getDataPublicacao(),
                livro.getCategoria(),
                editoraMapper.toEditoraSemLivro(livro.getEditora())
        );
    }
}
