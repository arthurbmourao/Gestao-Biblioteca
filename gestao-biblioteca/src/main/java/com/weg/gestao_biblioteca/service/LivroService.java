package com.weg.gestao_biblioteca.service;

import com.weg.gestao_biblioteca.dto.LivroRequestDto;
import com.weg.gestao_biblioteca.dto.LivroResponseDto;
import com.weg.gestao_biblioteca.mapper.LivroMapper;
import com.weg.gestao_biblioteca.model.Editora;
import com.weg.gestao_biblioteca.model.Livro;
import com.weg.gestao_biblioteca.model.enums.Categoria;
import com.weg.gestao_biblioteca.repository.EditoraRepository;
import com.weg.gestao_biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;
    private final EditoraRepository editoraRepository;

    public LivroResponseDto salvarLivro (LivroRequestDto livroRequestDto){
        Livro livro = mapper.toEntity(livroRequestDto);

        repository.save(livro);

        return mapper.toResponse(livro);
    }

    public List<LivroResponseDto> buscarPorTitulo(String titulo){
        Optional<Livro> livros = repository.findByTitulo(titulo);

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorCategoriaEPreco(Categoria categoria, BigDecimal preco){
        Optional<Livro> livros = repository.findByCategoriaAndPrecoLessThan(categoria,preco);

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorValorEntre(BigDecimal valor1, BigDecimal valor2){
        Optional<Livro> livros = repository.findByStartValorBetween(valor1,valor2);

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorCategoria(Categoria categoria){
        Optional<Livro> livros = repository.findByCategoria(categoria);

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorIsbnNull(){
        Optional<Livro> livros = repository.findByIsbnIsNull();

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorEditora(Long id){
        Editora editora = editoraRepository.findById(id).orElseThrow(() -> new RuntimeException("Id inválido"));

        Optional<Livro> livros = repository.findByEditoraOrderByTitulo(editora);

        return livros.stream().map(
                        mapper :: toResponse
                ).toList();

    }


    public Long buscarPorNacionalidadeAutor(String nacionalidade){
        Long qtdLivros = repository.countByAutoresNacionalidade(nacionalidade);

        return qtdLivros;
    }
}
