package com.jpql.biblioteca.controller;

import com.jpql.biblioteca.dto.*;
import com.jpql.biblioteca.projection.LivroMinimoProjection;
import com.jpql.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> criar(@RequestBody LivroRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.salvar(dto));
    }

    @GetMapping("/exercicio1")
    public ResponseEntity<List<LivroResponseDTO>> ex1(@RequestParam String titulo) {
        return ResponseEntity.ok(livroService.ex1Find(titulo));
    }

    @GetMapping("/exercicio2")
    public ResponseEntity<List<LivroResponseDTO>> ex2(@RequestParam String categoria, @RequestParam BigDecimal preco) {
        return ResponseEntity.ok(livroService.ex2And(categoria, preco));
    }

    @GetMapping("/exercicio3")
    public ResponseEntity<List<LivroResponseDTO>> ex3(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return ResponseEntity.ok(livroService.ex3Between(min, max));
    }

    @GetMapping("/exercicio5")
    public ResponseEntity<List<LivroResponseDTO>> ex5(@RequestParam List<String> categorias) {
        return ResponseEntity.ok(livroService.ex5In(categorias));
    }

    @GetMapping("/exercicio6")
    public ResponseEntity<List<LivroResponseDTO>> ex6() {
        return ResponseEntity.ok(livroService.ex6IsNull());
    }

    @GetMapping("/exercicio7/{editoraId}")
    public ResponseEntity<List<LivroResponseDTO>> ex7(@PathVariable Long editoraId) {
        return ResponseEntity.ok(livroService.ex7OrderBy(editoraId));
    }

    @GetMapping("/exercicio8")
    public ResponseEntity<Long> ex8(@RequestParam String nacionalidade) {
        return ResponseEntity.ok(livroService.ex8Count(nacionalidade));
    }

    @GetMapping("/exercicio9")
    public ResponseEntity<List<String>> ex9(@RequestParam String categoria) {
        return ResponseEntity.ok(livroService.ex9SelectSimples(categoria));
    }

    @GetMapping("/exercicio10")
    public ResponseEntity<List<LivroResponseDTO>> ex10(@RequestParam("autor") String nomeAutor) {
        return ResponseEntity.ok(livroService.ex10Join(nomeAutor));
    }

    @GetMapping("/exercicio11")
    public ResponseEntity<List<LivroResponseDTO>> ex11() {
        return ResponseEntity.ok(livroService.ex11JoinFetch());
    }

    @GetMapping("/exercicio12/{editoraId}")
    public ResponseEntity<BigDecimal> ex12(@PathVariable Long editoraId) {
        return ResponseEntity.ok(livroService.ex12Agregacao(editoraId));
    }

    @GetMapping("/exercicio13")
    public ResponseEntity<List<LivroResponseDTO>> ex13() {
        return ResponseEntity.ok(livroService.ex13Subquery());
    }

    @GetMapping("/exercicio14")
    public ResponseEntity<List<LivroResponseDTO>> ex14() {
        return ResponseEntity.ok(livroService.ex14SelectBasicoNativo());
    }

    @GetMapping("/exercicio15")
    public ResponseEntity<List<LivroResponseDTO>> ex15() {
        return ResponseEntity.ok(livroService.ex15JoinNativo());
    }

    @GetMapping("/exercicio16")
    public ResponseEntity<List<LivroResponseDTO>> ex16(@RequestParam String categoria) {
        return ResponseEntity.ok(livroService.ex16FuncaoBancoNativo(categoria));
    }

    @GetMapping("/exercicio17")
    public ResponseEntity<List<LivroMinimoProjection>> ex17() {
        return ResponseEntity.ok(livroService.ex17InterfaceProjection());
    }

    @GetMapping("/exercicio18")
    public ResponseEntity<List<EstatisticasEditoraDTO>> ex18() {
        return ResponseEntity.ok(livroService.ex18ClassBasedDto());
    }

    @GetMapping("/exercicio19")
    public ResponseEntity<List<LivroMinimoProjection>> ex19(@RequestParam BigDecimal precoMax) {
        return ResponseEntity.ok(livroService.ex19NativeProjection(precoMax));
    }

    @GetMapping("/exercicio20")
    public ResponseEntity<List<LivroMinimoProjection>> ex20(@RequestParam String categoria) {
        return ResponseEntity.ok(livroService.ex20DynamicProjection(categoria, LivroMinimoProjection.class));
    }
}