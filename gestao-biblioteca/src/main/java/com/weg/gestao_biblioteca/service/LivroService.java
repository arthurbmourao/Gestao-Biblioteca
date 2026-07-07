package com.weg.gestao_biblioteca.service;

import com.weg.gestao_biblioteca.dto.EditoraSemLivros;
import com.weg.gestao_biblioteca.dto.LivroRequestDto;
import com.weg.gestao_biblioteca.dto.LivroResponseDto;
import com.weg.gestao_biblioteca.dto.LivrosBrasileiros;
import com.weg.gestao_biblioteca.mapper.EditoraMapper;
import com.weg.gestao_biblioteca.mapper.LivroMapper;
import com.weg.gestao_biblioteca.model.Autor;
import com.weg.gestao_biblioteca.model.Editora;
import com.weg.gestao_biblioteca.model.Livro;
import com.weg.gestao_biblioteca.model.enums.Categoria;
import com.weg.gestao_biblioteca.projections.LivroProjection;
import com.weg.gestao_biblioteca.repository.AutorRepository;
import com.weg.gestao_biblioteca.repository.EditoraRepository;
import com.weg.gestao_biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;
    private final EditoraRepository editoraRepository;
    private final AutorRepository autorRepository;

    public LivroResponseDto salvarLivro (LivroRequestDto livroRequestDto){
        Editora editora = editoraRepository.findById(livroRequestDto.idEditora()).orElseThrow(() -> new RuntimeException("Id inválido"));
        List<Autor> autores = autorRepository.findAllById(livroRequestDto.listaIds());
        Livro livro = mapper.toEntity(livroRequestDto);

        livro.setEditora(editora);
        livro.setAutores(autores);
        livro.setTitulo(livroRequestDto.titulo());
        livro.setIsbn(livroRequestDto.isbn());
        livro.setCategoria(livroRequestDto.categoria());
        livro.setPreco(livroRequestDto.preco());
        livro.setDataPublicacao(LocalDate.now());

        repository.save(livro);
        LivroResponseDto livroResponseDto = mapper.toResponse(livro);

        return livroResponseDto;
    }



    public List<LivroResponseDto> buscarPorTitulo(String titulo){
        List<Livro> livros = repository.findByTitulo(titulo);

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorCategoriaEPreco(Categoria categoria, BigDecimal preco){
        List<Livro> livros = repository.findByCategoriaAndPrecoLessThan(categoria,preco);

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    //public List<LivroResponseDto> buscarPorValorEntre(BigDecimal valor1, BigDecimal valor2){
    //    List<Livro> livros = repository.findByStartValorBetween(valor1,valor2);
//
    //    return livros.stream().map(
    //                mapper :: toResponse
    //            ).toList();
    //}

    public List<LivroResponseDto> buscarPorCategoria(Categoria categoria){
        List<Livro> livros = repository.findByCategoria(categoria);

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorIsbnNull(){
        List<Livro> livros = repository.findByIsbnIsNull();

        return livros.stream().map(
                    mapper :: toResponse
                ).toList();
    }

    public List<LivroResponseDto> buscarPorEditora(Long id){
        Editora editora = editoraRepository.findById(id).orElseThrow(() -> new RuntimeException("Id inválido"));

        List<Livro> livros = repository.findByEditoraOrderByTitulo(editora);

        return livros.stream().map(
                        mapper :: toResponse
                ).toList();

    }


    public Long buscarPorNacionalidadeAutor(String nacionalidade){
        Long qtdLivros = repository.countByAutoresNacionalidade(nacionalidade);

        return qtdLivros;
    }

    public List<String> buscarPeloTitulosCat(Categoria categoria){
        List<String> titulos = repository.buscarTitulosPorCategoria(categoria);

        return titulos;
    }

    public List<String> buscarTitulosPorNome(String nome){
        List<String> titulos = repository.buscarNomePelosTitulos(nome);

        return titulos;
    }

    public List<LivrosBrasileiros> buscarLivrosBrasileiros(){
        List<LivroProjection> livros = repository.buscarLivrosBrasileiros();

        return livros.stream().map(
                mapper :: toLivroBrasil
        ).toList();
    }
}
