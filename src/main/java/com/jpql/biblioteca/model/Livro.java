package com.jpql.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "livro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @Column(nullable = false)
    private String categoria;

    @ManyToOne
    private Editora editora;

    @ManyToMany
    @JoinTable(name = "livro_autores")
    private List<Autor> autores;
}
