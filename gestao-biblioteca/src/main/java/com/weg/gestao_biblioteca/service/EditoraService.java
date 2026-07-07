package com.weg.gestao_biblioteca.service;

import com.weg.gestao_biblioteca.dto.EditoraRequestDto;
import com.weg.gestao_biblioteca.dto.EditoraResponseDto;
import com.weg.gestao_biblioteca.mapper.EditoraMapper;
import com.weg.gestao_biblioteca.model.Editora;
import com.weg.gestao_biblioteca.repository.EditoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditoraService {

    private final EditoraRepository repository;
    private final EditoraMapper mapper;

    public EditoraResponseDto salvarEditora(EditoraRequestDto editoraRequestDto){
        Editora editora = mapper.toEntity(editoraRequestDto);

        repository.save(editora);

        return mapper.toResponse(editora);
    }
}
