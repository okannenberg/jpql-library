package com.jpql.biblioteca.mapper;

import com.jpql.biblioteca.dto.LivroRequestDTO;
import com.jpql.biblioteca.dto.LivroResponseDTO;
import com.jpql.biblioteca.dto.AutorResumoDTO;
import com.jpql.biblioteca.model.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LivroMapper {

    private final EditoraMapper editoraMapper;
    private final AutorMapper autorMapper;

    public Livro toEntity(LivroRequestDTO dto) {
        if (dto == null) return null;

        return new Livro(
                dto.titulo(),
                dto.isbn(),
                dto.preco(),
                dto.dataPublicacao(),
                dto.categoria(),
                null,
                null
        );
    }

    public LivroResponseDTO toResponse(Livro livro) {
        if (livro == null) return null;

        List<AutorResumoDTO> autoresDTO = livro.getAutores() != null ?
                livro.getAutores().stream().map(autorMapper::toResumo).toList() : List.of();

        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getPreco(),
                livro.getDataPublicacao(),
                livro.getCategoria(),
                editoraMapper.toResumo(livro.getEditora()),
                autoresDTO
        );
    }
}