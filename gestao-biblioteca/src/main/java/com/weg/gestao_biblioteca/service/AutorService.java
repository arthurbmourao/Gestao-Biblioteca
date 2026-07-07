package com.weg.gestao_biblioteca.service;

import com.weg.gestao_biblioteca.dto.AutorRequestDto;
import com.weg.gestao_biblioteca.dto.AutorResponseDto;
import com.weg.gestao_biblioteca.dto.AutorSemLivroDto;
import com.weg.gestao_biblioteca.mapper.AutorMapper;
import com.weg.gestao_biblioteca.model.Autor;
import com.weg.gestao_biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorMapper autorMapper;
    private final AutorRepository autorRepository;

    public AutorSemLivroDto salvarAutor(AutorRequestDto autorRequestDto){

        Autor autor = autorMapper.toEntity(autorRequestDto);

        autorRepository.save(autor);

        return autorMapper.toAutorSemLivro(autor);
    }
}
