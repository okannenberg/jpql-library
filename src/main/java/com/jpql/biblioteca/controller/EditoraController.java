package com.jpql.biblioteca.controller;

import com.jpql.biblioteca.dto.EditoraRequestDTO;
import com.jpql.biblioteca.dto.EditoraResponseDTO;
import com.jpql.biblioteca.service.EditoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editoras")
@RequiredArgsConstructor
public class EditoraController {

    private final EditoraService editoraService;

    @PostMapping
    public ResponseEntity<EditoraResponseDTO> criar(@RequestBody EditoraRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.salvar(dto));
    }
}