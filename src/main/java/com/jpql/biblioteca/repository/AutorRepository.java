package com.jpql.biblioteca.repository;

import com.jpql.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    boolean existsById(Long id);
    List<Autor> findByNomeContainingIgnoreCase(String nome);
}