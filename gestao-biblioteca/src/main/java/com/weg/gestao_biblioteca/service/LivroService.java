package com.weg.gestao_biblioteca.service;

import com.weg.gestao_biblioteca.dto.LivroRequestDto;
import com.weg.gestao_biblioteca.dto.LivroResponseDto;
import com.weg.gestao_biblioteca.mapper.LivroMapper;
import com.weg.gestao_biblioteca.model.Livro;
import com.weg.gestao_biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;

    public LivroResponseDto salvarLivro (LivroRequestDto livroRequestDto){
        Livro livro = mapper.toEntity(livroRequestDto);

        repository.save(livro);

        return mapper.toResponse(livro);
    }
}
