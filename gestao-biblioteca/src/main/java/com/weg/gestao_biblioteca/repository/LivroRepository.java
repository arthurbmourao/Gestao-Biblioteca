package com.weg.gestao_biblioteca.repository;

import com.weg.gestao_biblioteca.model.Editora;
import com.weg.gestao_biblioteca.model.Livro;
import com.weg.gestao_biblioteca.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface LivroRepository extends JpaRepository <Livro, Long> {

    Optional<Livro> findByTitulo(String titulo);
    Optional<Livro> findByCategoriaAndPrecoLessThan(Categoria categoria, BigDecimal valor);
    Optional<Livro> findByStartValorBetween(BigDecimal valor1, BigDecimal valor2);
    Optional<Livro> findByCategoria(Categoria categoria);
    Optional<Livro> findByIsbnIsNull();
    Optional<Livro> findByEditoraOrderByTitulo(Editora editora);
    Long countByAutoresNacionalidade(String nacionalidade);
}
