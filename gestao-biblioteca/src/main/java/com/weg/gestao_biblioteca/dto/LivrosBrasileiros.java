package com.weg.gestao_biblioteca.dto;

import java.time.LocalDate;

public record LivrosBrasileiros(
        String titulo,
        LocalDate dataPublicacao
) {
}
