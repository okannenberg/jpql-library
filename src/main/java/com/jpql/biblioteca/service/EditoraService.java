package com.jpql.biblioteca.service;

import com.jpql.biblioteca.dto.EditoraRequestDTO;
import com.jpql.biblioteca.dto.EditoraResponseDTO;
import com.jpql.biblioteca.mapper.EditoraMapper;
import com.jpql.biblioteca.model.Editora;
import com.jpql.biblioteca.repository.EditoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EditoraService {

    private final EditoraRepository editoraRepository;
    private final EditoraMapper editoraMapper;

    @Transactional
    public EditoraResponseDTO salvar(EditoraRequestDTO dto) {
        Editora editora = editoraMapper.toEntity(dto);
        Editora editoraSalva = editoraRepository.save(editora);
        return editoraMapper.toResponse(editoraSalva);
    }
}