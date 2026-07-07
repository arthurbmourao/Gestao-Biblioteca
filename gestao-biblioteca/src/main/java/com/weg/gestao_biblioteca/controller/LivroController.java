package com.weg.gestao_biblioteca.controller;

import com.weg.gestao_biblioteca.dto.LivroRequestDto;
import com.weg.gestao_biblioteca.dto.LivroResponseDto;
import com.weg.gestao_biblioteca.dto.LivrosBrasileiros;
import com.weg.gestao_biblioteca.mapper.LivroMapper;
import com.weg.gestao_biblioteca.model.Livro;
import com.weg.gestao_biblioteca.model.enums.Categoria;
import com.weg.gestao_biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/livro")
public class LivroController {

    private final LivroMapper livroMapper;
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDto> salvarLivro(@RequestBody LivroRequestDto livroRequestDto){

        LivroResponseDto livroResponseDto = livroService.salvarLivro(livroRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(livroResponseDto);
    }

    @GetMapping("/titulo{titulo}")
    public ResponseEntity<List<LivroResponseDto>> buscarPorTitulo(@RequestParam String titulo){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPorTitulo(titulo));

    }

    @GetMapping("/categoria{categoria}/preco{preco}")
    public ResponseEntity<List<LivroResponseDto>> buscarPorCategoriaEPreco(@RequestParam Categoria categoria,@RequestParam BigDecimal preco){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPorCategoriaEPreco(categoria,preco));
    }

    @GetMapping("/categoria{categoria}")
    public ResponseEntity<List<LivroResponseDto>> buscarLivrosPorCategoria(@RequestParam Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPorCategoria(categoria));
    }

    @GetMapping("/isbn=null")
    public ResponseEntity<List<LivroResponseDto>> buscarIsbnNull(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPorIsbnNull());
    }

    @GetMapping("/editora{id}")
    public ResponseEntity<List<LivroResponseDto>> buscarPorEditora(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPorEditora(id));
    }

    @GetMapping("/nacionalidade{nacionalidade}")
    public ResponseEntity<Long> buscarNumerosPorNacionalidade(@RequestParam String nacionalidade){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPorNacionalidadeAutor(nacionalidade));
    }

    @GetMapping("/titulos{categoria}")
    public ResponseEntity<List<String>> buscarTitulosPorTitulo(@RequestParam Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarPeloTitulosCat(categoria));
    }

    @GetMapping("/titulos/nome{nome}")
    public ResponseEntity<List<String>> buscarTitulosPorNome(@RequestParam String nome){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarTitulosPorNome(nome));
    }

    @GetMapping("/brasileiros")
    public ResponseEntity<List<LivrosBrasileiros>> buscarLivrosBrasileiro(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarLivrosBrasileiros());
    }

    @PutMapping()
    public ResponseEntity<LivroResponseDto> atualizarLivro(@RequestParam Long id, @RequestBody LivroRequestDto livroRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.atualizarLivro(id, livroRequestDto));
    }

}
