package com.jpql.biblioteca.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record LivroResponseDTO(
        Long id,
        String titulo,
        String isbn,
        BigDecimal preco,
        LocalDate dataPublicacao,
        String categoria,
        EditoraResumoDTO editora,
        List<AutorResumoDTO> autores
) {
}
