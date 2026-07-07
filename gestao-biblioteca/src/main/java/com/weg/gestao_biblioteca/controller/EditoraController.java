package com.weg.gestao_biblioteca.controller;

import com.weg.gestao_biblioteca.dto.EditoraRequestDto;
import com.weg.gestao_biblioteca.dto.EditoraResponseDto;
import com.weg.gestao_biblioteca.mapper.EditoraMapper;
import com.weg.gestao_biblioteca.model.Editora;
import com.weg.gestao_biblioteca.service.EditoraService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/editora")
public class EditoraController {

    private final EditoraMapper editoraMapper;
    private final EditoraService editoraService;

    @PostMapping
    public ResponseEntity<EditoraResponseDto> salvarEditora(@RequestBody EditoraRequestDto editoraRequestDto){
        Editora editora = editoraMapper.toEntity(editoraRequestDto);

        editoraService.salvarEditora(editoraRequestDto);

        EditoraResponseDto editoraResponseDto = editoraMapper.toResponse(editora);

        return ResponseEntity.status(HttpStatus.CREATED).body(editoraResponseDto);
    }
}
