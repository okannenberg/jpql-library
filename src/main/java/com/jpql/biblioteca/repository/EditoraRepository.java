package com.jpql.biblioteca.repository;

import com.jpql.biblioteca.model.Autor;
import com.jpql.biblioteca.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    List<Autor> findByNomeContainingIgnoreCase(String nome);
}