package com.weg.gestao_biblioteca.controller;

import com.weg.gestao_biblioteca.dto.AutorRequestDto;
import com.weg.gestao_biblioteca.dto.AutorResponseDto;
import com.weg.gestao_biblioteca.dto.AutorSemLivroDto;
import com.weg.gestao_biblioteca.mapper.AutorMapper;
import com.weg.gestao_biblioteca.model.Autor;
import com.weg.gestao_biblioteca.service.AutorService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autor")
public class AutorController {

    private final AutorMapper autorMapper;
    private final AutorService autorService;


    @PostMapping
    public AutorSemLivroDto salvarAutor(@RequestBody AutorRequestDto autorRequestDto){
        Autor autor  = autorMapper.toEntity(autorRequestDto);
        autorService.salvarAutor(autorRequestDto);
        autor.setLivros(null);
        return autorMapper.toAutorSemLivro(autor);
    }
}
