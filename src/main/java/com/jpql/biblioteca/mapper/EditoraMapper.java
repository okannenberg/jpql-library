package com.jpql.biblioteca.mapper;

import com.jpql.biblioteca.dto.EditoraRequestDTO;
import com.jpql.biblioteca.dto.EditoraResponseDTO;
import com.jpql.biblioteca.dto.EditoraResumoDTO;
import com.jpql.biblioteca.model.Editora;
import org.springframework.stereotype.Component;

@Component
public class EditoraMapper {
    public Editora toEntity(EditoraRequestDTO editoraRequestDTO) {
        return new Editora(
                editoraRequestDTO.nome()
        );
    }

    public EditoraResponseDTO toResponse(Editora editora) {
        return new EditoraResponseDTO (
                editora.getId(),
                editora.getNome()
        );
    }

    public EditoraResumoDTO toResumo(Editora editora) {
        if (editora == null) return null;
        return new EditoraResumoDTO(editora.getId(), editora.getNome()); // Ajuste 'getNome' para o campo real da sua Editora
    }
}