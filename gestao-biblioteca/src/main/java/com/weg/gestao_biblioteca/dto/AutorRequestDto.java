package com.weg.gestao_biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AutorRequestDto(
        @NotNull(message = "Não pode ser nulo")
        @NotEmpty(message = "Não pode ser vazio")
        @NotBlank(message = "Não pode ser branco")
        String nome,
        @NotNull(message = "Não pode ser nulo")
        @NotEmpty(message = "Não pode ser vazio")
        @NotBlank(message = "Não pode ser branco")
        String nacionalidade
) {
}
