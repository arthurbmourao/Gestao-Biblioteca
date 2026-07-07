package com.weg.gestao_biblioteca.repository;

import com.weg.gestao_biblioteca.model.Editora;
import com.weg.gestao_biblioteca.model.Livro;
import com.weg.gestao_biblioteca.model.enums.Categoria;
import com.weg.gestao_biblioteca.projections.LivroProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long> {

    List<Livro> findByTitulo(String titulo);
    List<Livro> findByCategoriaAndPrecoLessThan(Categoria categoria, BigDecimal valor);
    //List<Livro> findByStartValorBetween(BigDecimal valor1, BigDecimal valor2);
    List<Livro> findByCategoria(Categoria categoria);
    List<Livro> findByIsbnIsNull();
    List<Livro> findByEditoraOrderByTitulo(Editora editora);
    Long countByAutoresNacionalidade(String nacionalidade);


    @Query("""
            Select l.titulo
            From Livro l
            Where categoria = :categoria
            """)
    List<String> buscarTitulosPorCategoria(@Param("categoria") Categoria categoria);

    @Query("""
            Select l.titulo
            From Livro l
            Join l.autores a
            Where a.nome = :nome
            """)
    List<String> buscarNomePelosTitulos(@Param("nome")String nome);

    @Query(value = """
            Select l.titulo AS titulo,
                l.data_publicacao AS dataPublicacao
            From livro l
            Inner Join livro_autores h
            ON h.livro_id  = l.id
            Inner join autor a
            ON a.id = h.autores_id
            WHERE a.nacionalidade = LOWER('brasileiro');
            
            """, nativeQuery = true)
    List<LivroProjection> buscarLivrosBrasileiros();

}
