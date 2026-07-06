package com.jpql.biblioteca.service;

import com.jpql.biblioteca.dto.AutorRequestDTO;
import com.jpql.biblioteca.dto.AutorResponseDTO;
import com.jpql.biblioteca.mapper.AutorMapper;
import com.jpql.biblioteca.model.Autor;
import com.jpql.biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    @Transactional
    public AutorResponseDTO salvar(AutorRequestDTO dto) {
        Autor autor = autorMapper.toEntity(dto);
        Autor autorSalvo = autorRepository.save(autor);
        return autorMapper.toResponse(autorSalvo);
    }

    @Transactional(readOnly = true)
    public List<AutorResponseDTO> buscarPorNomeQueContem(String nome) {
        return autorRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(autorMapper::toResponse)
                .toList();
    }
}