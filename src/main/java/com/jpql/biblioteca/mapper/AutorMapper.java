package com.jpql.biblioteca.mapper;

import com.jpql.biblioteca.dto.AutorRequestDTO;
import com.jpql.biblioteca.dto.AutorResponseDTO;
import com.jpql.biblioteca.dto.AutorResumoDTO;
import com.jpql.biblioteca.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {
    public Autor toEntity(AutorRequestDTO autorRequestDTO) {
        return new Autor(
                autorRequestDTO.nome(),
                autorRequestDTO.nacionalidade()
        );
    }

    public AutorResponseDTO toResponse(Autor autor) {
        return new AutorResponseDTO(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade()
        );
    }

    public AutorResumoDTO toResumo(Autor autor) {
        if (autor == null) return null;
        return new AutorResumoDTO(autor.getId(), autor.getNome());
    }
}