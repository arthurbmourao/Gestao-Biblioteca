package com.weg.gestao_biblioteca.dto;

import com.weg.gestao_biblioteca.model.enums.Categoria;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record LivroRequestDto(
        @NotNull(message = "Não pode ser nulo")
        @NotEmpty(message = "Não pode ser vazio")
        @NotBlank(message = "Não pode ser branco")
        String titulo,
        String isbn,
        Categoria categoria,
        Long idEditora,
        List<Long> listaIds,
        @Min(1)
        BigDecimal preco,
        @Past
        LocalDate dataPublicacao
) {
}
