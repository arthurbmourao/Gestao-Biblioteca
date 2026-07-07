package com.weg.gestao_biblioteca.projections;

import java.time.LocalDate;

public interface LivroProjection {
    String getTitulo();
    LocalDate getDataPublicacao();
}
