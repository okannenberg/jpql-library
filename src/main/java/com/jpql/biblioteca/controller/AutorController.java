package com.jpql.biblioteca.controller;

import com.jpql.biblioteca.dto.AutorRequestDTO;
import com.jpql.biblioteca.dto.AutorResponseDTO;
import com.jpql.biblioteca.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> criar(@RequestBody AutorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.salvar(dto));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AutorResponseDTO>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(autorService.buscarPorNomeQueContem(nome));
    }
}