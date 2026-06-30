package com.weg.gestao_biblioteca.repository;

import com.weg.gestao_biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Long> {
}
