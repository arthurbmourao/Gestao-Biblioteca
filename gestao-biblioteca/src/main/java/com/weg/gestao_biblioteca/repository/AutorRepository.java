package com.weg.gestao_biblioteca.repository;

import com.weg.gestao_biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository <Autor, Long> {

    Optional<Autor> findByNomeContainingIgnoreCase(String nome);
}
