package com.jpql.biblioteca.repository;

import com.jpql.biblioteca.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    boolean existsById(Long id);
}