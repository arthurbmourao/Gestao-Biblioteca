package com.weg.gestao_biblioteca.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LivroRequestDto(
        @NotNull(message = "Não pode ser nulo")
        @NotEmpty(message = "Não pode ser vazio")
        @NotBlank(message = "Não pode ser branco")
        String titulo,
        @NotNull(message = "Não pode ser nulo")
        @NotEmpty(message = "Não pode ser vazio")
        @NotBlank(message = "Não pode ser branco")
        String isbn,
        @Min(1)
        BigDecimal preco,
        @Past
        LocalDate dataPublicacao
) {
}
