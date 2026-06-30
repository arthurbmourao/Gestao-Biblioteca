package com.weg.gestao_biblioteca.repository;

import com.weg.gestao_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long> {
}
